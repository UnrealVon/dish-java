package dishDemo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DishApp {

    private static List<Dish> dishList = new ArrayList<>();
    private static List<Dish> orderList = new ArrayList<>();

    public static void main(String[] args) {
        inputBaseDish();//添加基本菜单
        
        Scanner in = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            showMenu();//显示用户界面部分
            try{
            int choice = in.nextInt();
            switch (choice){
                case 1:
                    System.out.println();
                    while (true){
                        showDish();//显示已有菜单
                        int id = in.nextInt();
                        if(id == 0){   //通过0返回上一级
                            break;
                        }
                        orderList.add(dishList.get(id-1));//在orderList添加所选菜品
                        System.out.println("已点"+id+"号菜品，名称是"+dishList.get(id-1).getName());
                        System.out.println();
                    }
                    System.out.println();
                    break;
                case 2:
                boolean f=true;
                    while(f){
                        if(orderList.size()==0){
                            System.out.println("您未下单任何菜品，请下单后再删除！");
                            System.out.println();
                            break;
                        }
                        System.out.println();
                        showOrder();//orderList非空显示列表
                        System.out.println("----请选择需要删除的相应菜品编号或按0取消----");
                        int id = in.nextInt();
                        
                        if(id==0)break;
                        for(Dish dish2:orderList){
                            if(id==dish2.getNo()){
                                f=false;
                            }
                        }
                        for(Dish dish2:orderList){
                            if(id==dish2.getNo()){
                            orderList.remove(dish2);
                            }
                        }
                        System.out.println("已删除"+id+"号菜品");
                    }
                    System.out.println();
                    break;
                    
                case 3:
                    System.out.println();
                    if(orderList.size()==0){
                        System.out.println("您未下单任何菜品");
                        System.out.println();
                        break;
                    }else
                        showOrder();
                    System.out.println();
                    break;
                case 4:
                    System.out.println();
                    buyOrder();//不设break语句，结账后自动跳转0
                case 0:
                    System.out.println("\t "+"欢迎下次光临");
                    flag = false;
                    break;

                case 12138:
                    System.out.println();
                    System.out.println("您已进入管理部分，请稍等...");
                    System.out.println();
                    Thread.sleep(1000);
                    Administrator a=new Administrator();
                    boolean flag02 = true;
                    while (flag02){
                        a.managementInterface();
                        Scanner nameScanner=new Scanner(System.in);
                        Scanner priceScanner=new Scanner(System.in);
                      Scanner noScanner=new Scanner(System.in);
                        int choice02 = in.nextInt();
                        switch (choice02){
                            case 1://显示已有菜品
                                System.out.println("已有菜品如下：");
                                for(Dish dish:dishList)
                                    System.out.println(dish.getNo()+"\t"+dish.getName()+"\t"+dish.getPrice());
                                System.out.println();
                                break;
                            case 2://增加菜品
                                System.out.println("已有菜品如下：");
                                for(Dish dish:dishList)
                                    System.out.println(dish.getNo()+"\t"+dish.getName()+"\t"+dish.getPrice());
                                System.out.println();
                                System.out.println("输入需要增加菜品数量，按0取消：");
                                int id = in.nextInt();
                                if(id == 0)   //通过0返回上一级
                                    break;
                                for(int i=0;i<id;i++){
                                    int j=i+1;
                                    System.out.println("第"+j+"个菜名和价格：");
                                    String addName=nameScanner.next();
                                    double addPrince=priceScanner.nextDouble();
                                    dishList.add(a.addDish(0,addName,addPrince));
                                }
                                System.out.println("添加成功！");
                                a.adjustMenu((ArrayList<Dish>) dishList);//调整菜单序号，令序号为所在位置
                                System.out.println();
                                break;

                            case 3://修改菜
                                System.out.println();
                                while(true){
                                    System.out.println("菜单如下：");
                                    for(Dish dish:dishList)
                                        System.out.println(dish.getNo()+"\t"+dish.getName()+"\t"+dish.getPrice());
                                    System.out.println("输入修改的菜品序号、名称、价格，按0取消：");
                                    int setNo = noScanner.nextInt();
                                    if(setNo==0)break;
                                    String seyName=nameScanner.next();
                                    double setPrince=priceScanner.nextDouble();
                                    dishList.set(setNo-1, new Dish(setNo,seyName,setPrince));
                                    System.out.println("修改完成！");
                                    System.out.println();
                                }
                                System.out.println();
                                break;
                            case 4://删除菜单菜品
                                System.out.println();
                                while (true){
                                    System.out.println("菜单如下：");
                                    for(Dish dish:dishList)
                                        System.out.println(dish.getNo()+"\t"+dish.getName()+"\t"+dish.getPrice());
                                    System.out.print("请输入需要删除的菜品序号，按0取消:");
                                    int removeNo = noScanner.nextInt();
                                    if(removeNo == 0)//通过0返回上一级
                                        break;
                                    System.out.print("已删除\t");
                                    System.out.println(dishList.get(removeNo-1).getName()+"\t"+dishList.get(removeNo-1).getPrice());
                                    dishList.remove(removeNo-1);
                                    a.adjustMenu((ArrayList<Dish>) dishList);//调整菜单序号
                                    System.out.println();
                                }
                                System.out.println();
                                break;
                            case 0://退出
                                flag02=false;
                                System.out.println();
                                break;
                            default:       //输入非0、1、2、3、4外其他整型
                                System.out.println("输入错误！");
                                System.out.println("请重新输入！");
                                System.out.println();
                                break;
                    
                        }
                    }
                    System.out.println();
                    break;
                default:       //输入非0、1、2、3、4以及250外其他整型
                    System.out.println("输入错误！");
                    System.out.println("请重新输入！");
                    System.out.println();
                    break;
            
            }
        }catch(InputMismatchException e){
            System.err.println("输入数据类型错误，请输入整型数据！");
            in.next();
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    }

    public static void buyOrder() {
        try {
        System.out.println("结账中，请稍后.");
            Thread.sleep(1000);
        System.out.println("结账中，请稍后..");
            Thread.sleep(1000);
        System.out.println("结账中，请稍后...");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        double total = 0;
        for(Dish dish : orderList){
            total+= dish.getPrice();
        }
        System.out.println("您本次共计消费"+total+"元");
    }
    //基本菜品
    public static void inputBaseDish(){
        dishList.add(new Dish(1,"烧茄子",15.0));
        dishList.add(new Dish(2,"蒸馒头",10.5));
        dishList.add(new Dish(3,"炖鲫鱼",20.4));
        dishList.add(new Dish(4,"炒牛肉",33.0));
        dishList.add(new Dish(5,"炸豆腐",7.0));
    }
    //主页面
    public static void showMenu(){
        System.out.println("--------主菜单--------");
        System.out.println("1\t菜单");
        System.out.println("2\t删除菜单");
        System.out.println("3\t已点菜单");
        System.out.println("4\t结账");
        System.out.println("0\t退出");
        System.out.println("----根据编号选择相应服务----");
    }
    //点菜
    public static void showDish(){
        System.out.println("----请点菜，选择相应菜品编号----");
        for(Dish dish:dishList){
            System.out.println(dish.getNo()+"\t"+dish.getName()+"\t"+dish.getPrice());
        }
        System.out.println("-----按0返回上一级-----");
    }
    public static void showOrder(){
        System.out.println("亲，您已点以下菜品：");
        System.out.println("编号\t名称\t\t价格");
        for(Dish dish:orderList){
            System.out.println(dish.getNo()+"\t"+dish.getName()+"\t"+dish.getPrice());
        }
    }
}
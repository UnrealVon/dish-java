package dishDemo;

import java.util.ArrayList;
import java.util.List;

public class Administrator {
    protected static String id=null;

    public Dish addDish(int no,String name,double price){
        return new Dish(no,name,price);
    }

    public void moveDish(){
        
    }

    public List adjustMenu(ArrayList<Dish> listt){//调整菜单序号

        int j=0;
        for(Dish dish2:listt){
            
            
            if(j+1!=dish2.getNo()){
                dish2.change_no(j+1);
            }
            j++;
        }
        return listt;
    }

    public void managementInterface(){
        System.out.println("--------管理界面--------");
        System.out.println("1\t显示已有菜品");
        System.out.println("2\t增加菜品");
        System.out.println("3\t修改菜品");
        System.out.println("4\t删除菜品");
        System.out.println("0\t退出");
        System.out.println("----根据编号选择相应服务----");
    }
}

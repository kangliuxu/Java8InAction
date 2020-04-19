package lambdasinaction.chap2;


import java.util.ArrayList;
import java.util.List;

/**
 * @author xkl
 * @date 2020/4/19
 * @description 灵活的打印苹果数据的方法
 **/
public class PrettyPrint {

    public static void prettyPrintApple(List<FilteringApples.Apple> appleList,AppleFormatter appleFormatter){
        for(FilteringApples.Apple apple:appleList){
            String result = appleFormatter.accept(apple);
            System.out.println(result);
        }
    }


    public static void main(String[] args) {
        List<FilteringApples.Apple> appleList = new ArrayList<>();
        appleList.add(new FilteringApples.Apple(80,"green"));
        appleList.add(new FilteringApples.Apple(180,"red"));
        appleList.add(new FilteringApples.Apple(100,"green"));
        prettyPrintApple(appleList,new PrettyPrint.WeightPrintStrategy());
        prettyPrintApple(appleList,new PrettyPrint.ColorAndWeightPrintStrategy());

    }


    static interface AppleFormatter{
        String accept(FilteringApples.Apple apple);
    }

    static class WeightPrintStrategy implements AppleFormatter{
        @Override
        public String accept(FilteringApples.Apple apple) {
            return "apple weight:"+apple.getWeight();
        }
    }

    static class ColorAndWeightPrintStrategy implements AppleFormatter{
        @Override
        public String accept(FilteringApples.Apple apple) {
           return "apple color:"+apple.getColor()+" 重量:"+apple.getWeight();
        }
    }



}

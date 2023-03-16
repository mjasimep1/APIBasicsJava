package JSONParse;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

public class ComplexJsonParse {
    public static void main(String[] args){
        int totalSum=0;

        JsonPath js=new JsonPath(PayLoad.coursePrice());
        //Get the course counts
        int count=js.getInt("courses.size()");
        System.out.println("count: "+count);

        //Print purchase amount
        int purchAmount=js.getInt("dashboard.purchaseAmount");
        System.out.println("price: "+purchAmount);

        //Print title of the first course
        String fTitle=js.getString("courses[0].title");
        System.out.println("title: "+fTitle);

        //Print All course titles and their respective Prices
        for(int i=0;i<count;i++){
            String Titles=js.getString("courses["+i+"].title");
            String prices=js.getString("courses["+i+"].price");
            System.out.println("Title is "+Titles+" and it price is "+prices);
        }

        //Print no of copies sold by RPA Course
        for(int i=0;i<count;i++) {
            String Titles1 = js.getString("courses[" + i + "].title");
            if (Titles1.equalsIgnoreCase("RPA")) {
                String prices1 = js.getString("courses[" + i + "].price");
                System.out.println("-------------------------");
                System.out.println("Title is " + Titles1 + " and it price is " + prices1);
                System.out.println("-------------------------");
                break;
            }
        }

            //Verify if Sum of all Course prices matches with Purchase Amount

            for(int j=0;j<count;j++) {
                int prices2 = js.getInt("courses["+j+"].price");
                int copies2 = js.getInt("courses["+j+"].copies");
                int sum = prices2 * copies2;
                System.out.println(sum);
                totalSum=totalSum+sum;
            }
        //System.out.println(totalSum);
        int purchAmount2=js.getInt("dashboard.purchaseAmount");
        //System.out.println(purchAmount2);
        Assert.assertEquals(totalSum, purchAmount2);





        }


}

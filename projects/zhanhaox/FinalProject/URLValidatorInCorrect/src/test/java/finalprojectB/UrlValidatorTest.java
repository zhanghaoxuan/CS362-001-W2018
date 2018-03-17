
package finalprojectB;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {

   private boolean printStatus = false;
   private boolean printIndex = false;

   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest() {
      System.out.println("testManualTest");
      UrlValidator val = new UrlValidator(null,null,UrlValidator.ALLOW_ALL_SCHEMES);
      System.out.println("Test url: http://www.google.com, expect: true");
      System.out.println(val.isValid("http://www.google.com"));
      System.out.println("Test url: www.amazon.com, expect: false");
      System.out.println(val.isValid("www.amazon.com"));
      System.out.println("Test url: http://www.localhost.com/, expect: true");
      System.out.println(val.isValid("http://localhost.com/"));
      System.out.println("Test url: http://www.localhost.com:, expect: false");
      System.out.println(val.isValid("http://localhost.com:"));
      System.out.println("Test url: http://www.localhost.com?action=raw, expect: true");
      System.out.println(val.isValid("http://localhost.com?action=raw"));
      System.out.println("Test url: http://www.localhost.com?action=, expect: true");
      System.out.println(val.isValid("http://localhost.com?action="));
      System.out.println("Test url: htp://www.localhost.com,expect:true");
      System.out.println(val.isValid("htp://www.localhost.com"));
//You can use this function to implement your manual testing
	   
   }
   
   
   public void testYourFirstPartition() {
         System.out.println("\nSchemes partition testing");
         String[] testschemes={"://","ftp://"," ","htp://",":/","http://"};
         UrlValidator scval=new UrlValidator(testschemes, 0);
         int len=testschemes.length;
         for(int i=0;i<len;i++){
            System.out.println(testschemes[i]);
            boolean result=scval.isValidScheme(testschemes[i]);
            if(result==true){
               System.out.println("GOOD SCHEMES");
            }
            else{
               System.out.println("Bad SCHEMES");
            }
         }
   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing
         System.out.println("\nAuthority partition testing");
         String[] testauthorities={"www.localhost.com","www.localhost-.com","localhost.com:"};
         UrlValidator authorityval=new UrlValidator(testauthorities,0);
         int len=testauthorities.length;
         for (int i=0;i<len;i++){
            System.out.println(testauthorities[i]);
            String temp=testauthorities[i];
            boolean result=authorityval.isValidAuthority(temp);
            if(result==true){
               System.out.println("GOOD AUTHORITY");
            }
            else{
               System.out.println("BAD AUTHORITY");
            }
         }
   }
   //You need to create more test cases for your Partitions if you need to 

   public void testYourThirdPartition(){
         System.out.println("\nPath partition testing");
         String[] testpaths={"/","/path","//path","path"};
         UrlValidator pathval=new UrlValidator(testpaths,0);
         int len=testpaths.length;
         for(int i=0;i<len;i++){
            System.out.println(testpaths[i]);
            String temp=testpaths[i];
            boolean result=pathval.isValidPath(temp);
            if(result==true){
               System.out.println("GOOD PATH");
            }
            else{
               System.out.println("BAD PATH");
            }
         }
   }

   public void testYourFouthPartition(){
      System.out.println("\nQuery partition testing");
      String[] testqueries={"?action","?action=raw"," ","??action=raw"};
      UrlValidator queryval=new UrlValidator(testqueries,0);
      int len=testqueries.length;
      for(int i=0;i<len;i++){
         System.out.println(testqueries[i]);
         String temp=testqueries[i];
         boolean result=queryval.isValidQuery(temp);
         if(result==true){
            System.out.println("GOOD QUERY");
         }
         else{
            System.out.println("BAD QUERY");
         }
      }
   }



   public void testIsValid() {
	   //You can use this function for programming based testing
      String goodschemes="http://";
      String goodauthority="www.localhost.com";
      String port=":100";
      String goodpath="/path";
      String goodquery="?action=raw";
      String url=goodschemes+goodauthority+port+goodpath+goodquery;
      UrlValidator validator=new UrlValidator();
      System.out.println("The test url is: "+ url);
      boolean result=validator.isValid(url);
      if(result==true){
         System.out.println("GOOD URL");
      }
      else{
         System.out.println("BAD URL");
      }
   }
   


}

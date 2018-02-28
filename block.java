
/**
 * Write a description of class Block here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Block
{    
    String bColor;
    Rectangle block;    
    LeftCorner  leftCorner;
    RightCorner  rightCorner;
    
    /**
     * Constructor for objects of class Block
     */
    public Block(int[] topLeft, int[] bottomRight, String color){
        block = new Rectangle();
        leftCorner = new LeftCorner(topLeft);
        rightCorner = new RightCorner(bottomRight);
        bColor = new String(color);
        block.setPosition(topLeft[0],topLeft[1]);
        block.changeSize(bottomRight[0] - topLeft[0],bottomRight[1] - topLeft[1]);
        block.changeColor(color);
        
    }

    /**
     * Turn the block Visible
     */
    public void makeVisible()
    {
        block.makeVisible();        
    }
    
    /**
     * Turn the block Invisible
     */
    public void makeInvisible()
    {
       block.makeInvisible(); 
       leftCorner.makeInvisible();
       rightCorner.makeInvisible();
    }
    
    /**
     * Asserts if the parameter are equal to the Right corner
    */
    public boolean equalsRightCorner(int[] buttomRight){
        return rightCorner.equals(buttomRight);
    }
    
    /**
     * Asserts if the parameter are equal to the left corner
    */
   public boolean equalsLeftCorner(int[] topLeft){
        return leftCorner.equals(topLeft);
    }
    
   /**
     * Compare the block color whit the desire color
    */
   public boolean colorEquals(String color){
       return bColor.equals(color);
   }
   
   /*
     * get the rightCorner
     */
   public RightCorner getRightCorner(){
       return rightCorner;
   }
   
   /*
     * get the leftCorner
     */
    public LeftCorner getLeftCorner(){
       return leftCorner;
   }
   
   /*
    * Assert if the block A is inside the block B
    */
   public boolean hasInside(Block B){
       boolean assertLeft = leftCorner.isGreaterThan(B.getLeftCorner());
       boolean assertRight = rightCorner.isGreaterThan(B.getRightCorner());
       if(assertLeft && assertRight) return true;
       else return false;
   }
   
   /*
    * Assert if the block A is inside the block B
    */
   public boolean hasNotInside(Block B){
       boolean assertLeft = leftCorner.firstCondition(B.getLeftCorner());
       boolean assertRight = rightCorner.isGreaterThan(B.getRightCorner());
       if(assertLeft && assertRight) return true;
       else return false;
   }
}

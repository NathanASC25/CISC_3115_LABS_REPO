public abstract class Window implements GUIComponent {
   private int width;
   private int height;
   private boolean isMinimized;
   private boolean isVisible;
   private boolean isResized;
   private boolean isRestored;
   public Window(int width, int height) {
       this.width = width;
       this.height = height;
       isResized = false;
       isRestored = false;
   }
   public int getWidth() {
       return width;
   }
   public int getHeight() {
       return height;
   }
   public void setWidth(int width) {
       if (width > 0) {
           this.width = width;
       }
   }
   public void setHeight(int height) {
       if (height > 0) {
           this.height = height;
       }
   }
   @Override
   public String toString() {
       return "a " + getWidth() + "x" + getHeight();
   }
   @Override
   public boolean isVisible() {
       return isVisible;
   }
   @Override
   public void setVisible(boolean isVisible) {
       this.isVisible = isVisible;
   }
   @Override
   public void display() {
       if (!isVisible) {
           System.out.println("(Nothing to see here)");
       }
       else if (isResized || isRestored) {
           System.out.println(".......................");	
           System.out.println(":" + this + ":");
           System.out.println(".......................");
           if (isResized) {
               isResized = false;	
           }
           else {
               isRestored = false;	
           }
       }
       else if (isMinimized) {
       	System.out.println("[" + this + " (minimized)]");
       }
       else {
           displayNormal();
       }
   }
   public abstract void displayNormal();
   public void resize(int width, int height) {
       setWidth(width);
       setHeight(height);
       isResized = true;
   }
   public void minimize() {
       isMinimized = true;
   }
   public void restore() {
       width = 5;
       height = 10;
       isRestored = true;
   }
}

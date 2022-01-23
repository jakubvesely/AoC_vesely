
package passagepathing;

public class Cave {
    
    int[] joints;
    int count=0;
    boolean big;
    String name;
    
    public Cave(String name, int r){
        joints = new int[r];
        this.name=name;
        if(name.equals(name.toLowerCase())){
            big=false;
        }else{
            big=true;
        }
    }
    
    public void connect(int index){
        joints[count]=index;
        count++;
    }
    public String getName(){
        return name;
    }
    public int[] getJoints(){
        return joints;
    }
    public int getCount(){
        return count;
    }
    public boolean getType(){
        return big;
    }
    
}

public class Keyword {
	public String name;
    public int count;
    public int weight;
    
    public Keyword(String name,int count){
		this.name = name;
		this.count =count;
    }
    
    @Override
    public String toString(){
    	return "["+name+","+count+"]";
    }
   
}
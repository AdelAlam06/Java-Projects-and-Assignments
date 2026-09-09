public class BigO extends Polynomial{
    private String category = "";
    private int deg = 0;
    public BigO(int[] poly){
        super(poly);
         deg = getDegree();
        if(deg == 0){
            category = "constant";
        }
        else if (deg == 1){
            category = "linear";
        }
        else if (deg == 2){
            category = "quadratic";
        }
        else if (deg == 3){
            category = "cubic";
        }
        else if (deg >= 4){
            category = "polynomial";
        }
    }

    public String getCategory(){
        return category;
    }

    @Override
    public String toString(){
        String bigO = "O(";
        if(deg == 0){
            bigO += 1 + ")"; 
        }
        else if(deg == 1){
            bigO += "n)"; 
        }
        else if(deg > 1){
            bigO += "n^" + deg + ")"; 
        }
        return bigO;
    }
}

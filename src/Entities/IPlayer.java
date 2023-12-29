package Entities;

public class IPlayer implements IEntity {
    String name = "";
    double pts = 0;
    double trb = 0;
    double ast = 0;
    double blk = 0;
    double stl = 0;
    String position;

    public IPlayer(String name, double pts, double trb, double ast, double blk, double stl){
        this.name = name;
        this.pts = pts;
        this.trb = trb;
        this.ast = ast;
        this.blk = blk;
        this.stl = stl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public double getTrb() {
        return trb;
    }

    public void setTrb(int trb) {
        this.trb = trb;
    }

    public double getAst() {
        return ast;
    }

    public void setAst(int ast) {
        this.ast = ast;
    }

    public double getBlk() {
        return blk;
    }

    public void setBlk(int blk) {
        this.blk = blk;
    }

    public double getStl() {
        return stl;
    }

    public void setStl(int stl) {
        this.stl = stl;
    }
    public String getPosition(){
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public double getWeightedPts(){
        double weight = 0;
        switch (getPosition()) {
            case "C", "SF":
                weight =  0.2;
                break;
            case "PF", "PG":
                weight = 0.3;
                break;
            case "SG":
                weight = 0.4;
                break;
        }

        return weight;
    }

    public double getWeightedTrb(){
        double weight = 0;
        switch (getPosition()) {
            case "C", "PF":
                weight =  0.3;
                break;
            case "PG", "SG":
                weight = 0.1;
                break;
            case "SF":
                weight = 0.2;
                break;
        }

        return weight;
    }

    public double getWeightedAst(){
        double weight = 0;
        switch (getPosition()) {
            case "C":
                break;
            case "PF":
                weight = 0.1;
                break;
            case "PG":
                weight = 0.4;
                break;
            case "SF":
                weight = 0.15;
                break;
            case "SG":
                weight = 0.3;
        }

        return weight;
    }

    public double getWeightedBlk(){
        double weight = 0;
        switch (getPosition()) {
            case "C":
                weight = 0.4;
                break;
            case "PF", "SF":
                weight = 0.2;
                break;
            case "PG", "SG":
                weight = 0.1;
                break;
        }

        return weight;
    }

    public double getWeightedStl(){
        double weight = 0;
        switch (getPosition()) {
            case "C", "PF", "PG", "SG":
                weight = 0.1;
                break;
            case "SF":
                weight = 0.25;
                break;
        }

        return weight;
    }
}

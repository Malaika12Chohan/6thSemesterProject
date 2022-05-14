package aligoldsmith.com;

public class Model {


    String jName;
    String jDetail;
    int jPhoto;

    public Model(String jName,String jDetail,int jPhoto) {
        this.jName = jName;
        this.jDetail=jDetail;
        this.jPhoto=jPhoto;
    }

    public String getjName() {
        return jName;
    }

    public String getjDetail() {
        return jDetail;
    }

    public int getjPhoto() {
        return jPhoto;
    }
}

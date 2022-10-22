package item13.objectclass_specific;

public class X implements Cloneable {
    int field1;
    String field2;

    public X(int field1, String field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    @Override
    protected Object clone()  {
        try {
            return (X) super.clone();
        } catch ( CloneNotSupportedException E){
            throw new AssertionError();
        }
    }

}

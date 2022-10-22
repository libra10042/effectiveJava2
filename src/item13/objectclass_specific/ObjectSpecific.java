package item13.objectclass_specific;

public class ObjectSpecific {
    public static void main(String[] args) throws CloneNotSupportedException {
        X x = new X(1, "X");

        boolean isCloneSame = x != x.clone();
        System.out.println(isCloneSame); //true

        boolean isTypeEqual = x.clone().getClass() == x.getClass();
        System.out.println(isTypeEqual); // true, not an absolute requirement

        boolean equals = x.clone().equals(x);
        System.out.println(equals); // false : equals를 override 하지 않아서 false

        X clonedX = (X) x.clone();
        boolean isFields1Equals = clonedX.field1 == x.field1;
        boolean isFields2Equals = clonedX.field2 == (x.field2);
        System.out.println("is field 1 Equal? " + isFields1Equals);
        System.out.println("is field 2 Equal? " + isFields2Equals);

    }
}

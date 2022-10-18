package item7.ex4.synchronous_callback;

interface OnGeekEventListener {
    void onGeekEvent();
}

class B {
    private OnGeekEventListener mListener; // listener field

    public void registerOnGeekEventListener(OnGeekEventListener mListener){
        this.mListener = mListener;
    }

    public void doGeekStuff(){
        System.out.println("Performing callback before synchronized Task");

        // check if listener is registered.
        if(this.mListener != null){
            mListener.onGeekEvent();
        }
    }

    public static void main(String[] args) {
        B obj = new B();
        OnGeekEventListener mListener = new A();
        obj.registerOnGeekEventListener(mListener);
        obj.doGeekStuff();
    }
}

public class A implements OnGeekEventListener{
    @Override
    public void onGeekEvent() {
        System.out.println("Performing callback after synchronous Task");
    }
}

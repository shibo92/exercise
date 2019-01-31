package DesignPatterns;

public class MyBuilder {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static Builder Builder(){
        return new Builder();
    }

    public String toString(){
        return "name : " + this.getName() + "\t age : " + this.age;
    }

    public static class Builder {
        private String name;
        private int age;
        public Builder setName(String name){
            this.name = name;
            return this;
        }
        public Builder setAge(int age){
            this.age = age;
            return this;
        }

        public MyBuilder build(){
            MyBuilder myBuilder = new MyBuilder();
            myBuilder.setAge(this.age);
            myBuilder.setName(this.name);
            return myBuilder;
        }
    }

    public static void main(String[] args) {
        MyBuilder myBuilder = MyBuilder.Builder().setAge(11).setName("walle").build();
        System.out.println(myBuilder);
    }
}

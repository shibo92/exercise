package DesignPatterns;

public class Person {
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
        return "name : " + this.getName() + "\t age : " + this.getAge();
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

        public Person build(){
            Person personBuilder = new Person();
            personBuilder.setAge(this.age);
            personBuilder.setName(this.name);
            return personBuilder;
        }
    }

    public static void main(String[] args) {
        Person person = Person.Builder().setAge(11).setName("walle").build();
        System.out.println(person);
    }
}

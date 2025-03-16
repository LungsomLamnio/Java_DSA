package OOPs;
// public class OOPS {
//     public static void main(String[] args) {
//         Horse h = new Horse();
//         System.out.println(h.color);
        
        
//     }
// }

// class Animal {
//     String color;
//     Animal() {
//         System.out.println("Animal constructor is called....");
//     }
// }

// class Horse extends Animal {
    
//     Horse() {
//         super.color = "Brown";
//         System.out.println("Horse Constructor is called......");
//     }
// }

// class Pony extends Horse {
//     Pony() {
//         System.out.println("Pony Constructor is called...");
//     }
// }
// class Chicken extends Animal {
//     void changeColor() {
//         color = "White";
//     }
//     void walk() {
//         System.out.println("Walks with two legs");
//     }
// }
// class Animals {
//     String skinColor;

//     void eat() {
//         System.out.println("Eats Anything");
//     }
//     void breathe() {
//         System.out.println("Breathes");
//     }

// }

// class Fish extends Animals {
//     int fins;

//     void eat() {
//         System.out.println("Eats phytoplankton");
//     }
//     void swim() {
//         System.out.println("Swims");
//     }
// }

// class MethodOverloading {
//     int sum(int a, int b) {
//         return a+b;
//     }
//     float sum(float a, float b) {
//         return a+b;
//     }
//     int sum(int a, int b, int c) {
//         return a+b+c;
//     }
// }

// class Student {
//     String name;
//     int rollno;
//     String password;
//     int marks[];

//     Student() {
//         marks = new int[3];
//     }

//     //Shallow Copy Constructor
//     // Student(Student s1) {
//     //     marks = new int[3];
//     //     this.name = s1.name;
//     //     this.rollno = s1.rollno;
//     //     this.marks = s1.marks;
//     // }

//     //Deep Copy Constructor
//     Student(Student s1) {
//         marks = new int[3];
//         this.name = s1.name;
//         this.rollno = s1.rollno;
//         for(int i=0; i<3; i++) {
//             this.marks[i] = s1.marks[i];
//         }
//     }
// }

// class Pen {
//     String color;
//     int tip;

//     void setColor(String newColor) {
//         color = newColor;  
//     }

//     void setTip(int newTip) {
//         tip = newTip;
//     }
// }

// class BankAccount {
//     public String name;
//     private String password;

//     public void setPassword(String newPassword) {
//         password = newPassword;
//     }

//     String getPassword() {
//         return this.password;
//     }
// }

class Pen {
    String color;
    int tip;

    void setColor(String newColor) {
        color = newColor;
    }

    void setTip(int newTip) {
        tip = newTip;
    }
}

class BankAccount {
    String username;
    private String password;

    public void setPassword(String newPassword) {
        password = newPassword;
    }

    public String getPassword() {
        return password;
    }
}

class Student {
    String name;
    int rollno;
    int marks[];

    Student() {
        System.out.println("Constructor is called");
        marks = new int[3];
    }

    Student(Student s1) {
        this.name = s1.name;
        this.rollno = s1.rollno;
        this.marks = s1.marks;
    }
}

abstract class Animal {
    void eat() {
        System.out.println("eat anything");
    }

    abstract void walk();
}

class Deer extends Animal {
    void walk() {
        System.out.println("walk with 4 legs");
    }
}

interface Chess {
    void move();
}

class Queen implements Chess {
    public void move() {
        System.out.println("moves in all directions");
    }
}

class Drinks {
    void volume() {
        System.out.println("in litres");
    }
}

class Pepsi extends Drinks {
    void volume() {
        super.volume();
        System.out.println("2 litres");
    }
}

public class OOPS {
    public static void main(String[] args) {
        Pepsi p1 = new Pepsi();
        p1.volume();
    }
}
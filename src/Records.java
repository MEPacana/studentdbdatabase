/*	check remove....
 *	Lab 10: File Reading and Writing with Lists
 *	performed by Michael Loewe L. Alivio, Michael Ervin B. Pacana, and Juan Carlos T. Roldan
 *  latest edit by Juan Carlos Roldan 8:50 PM
 *  parts of code may be copied from Sir Nico Enego's file reading and writing repository
 */
import java.io.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Records {
    private static final String FILE_NAME = "C:\\Users\\User\\Documents\\Second Year First Sem\\studentdbdatabase\\src\\db.ser";
    public static void main(String[] args){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        List<Student> record = new LinkedList<Student>();
        Student temp = new Student();
        Scanner in = new Scanner(System.in);
        BufferedReader br = null;
        try {
            // DESERIALIZATION...
            File fin = new File(FILE_NAME);
            if(!fin.exists()) {
                fin.createNewFile();
            }
            fis = new FileInputStream(fin);
            if(fin.length() != 0) {
                ois = new ObjectInputStream(fis);
                record = (List) ois.readObject();
                ois.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException ce) {
            // this might be thrown by ois.readObject()
            ce.printStackTrace();
        } finally{
            try{
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        int choice;
        String tempString;
        do{
            System.out.println("\t\tMenu\n\t1. Register student\n\t2. Search for a student\n\t3. Remove student from list\n\t4. Save\n\t5. Display list\n\t6. Update\n\t7. Exit");
            choice = in.nextInt();
            switch(choice){
                case 1:
                    Scanner ln = new Scanner(System.in); //using a different scanner object flushes the newline character
                    temp.setStudentNumber(ln.nextLine());
                    temp.setFirstName(ln.nextLine());
                    temp.setMiddleInitial(ln.nextLine().charAt(0));
                    temp.setLastName(ln.nextLine());
                    temp.setCourse(ln.nextLine());
                    try{
                        temp.setYearLevel(Integer.parseInt(ln.next()));
                    } catch (NumberFormatException e){
                        e.printStackTrace();
                    }
                    ln = new Scanner(System.in);

                    temp.setCrushName(ln.nextLine());
                    temp.setCourseCode(ln.nextLine());
                    temp.setCourseDes(ln.nextLine());

                    record.add(temp);
                    System.out.println("Student added!");
                    display(record);
                    break;

                case 2:
                    in.nextLine();
                    tempString = in.nextLine();

                    for(Student l : record){
                        if(tempString.compareTo(l.getStudentNumber()) == 0){
                            System.out.println(l);
                        }
                    }
                    break;

                case 3:
                    tempString = in.next();
                    int removeIndex = -1, i = 0;
                    for(Student l : record){
                        if(tempString.compareTo(l.getStudentNumber()) == 0){
                            removeIndex = i;
                            break;
                        }
                        i++;
                    }
                    if(i != record.size() && record.size() != 0){
                        record.remove(removeIndex);
                    }
                    display(record);
                    break;

                case 4:
                    try {
                        // declare and construct object
                        // print them out. note: toString() methods have been defined
                        // SERIALIZATION...
                        File fout = new File(FILE_NAME);
                        fos = new FileOutputStream(fout);
                        oos = new ObjectOutputStream(fos);

                        oos.writeObject(record);
                        oos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        try {
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 5:
                    System.out.println("Displaying contents of the student list:");
                    display(record);
                    break;
                case 6:
                    Scanner ln2 = new Scanner(System.in);
                    System.out.println("Enter Student Number: ");
                    tempString = ln2.nextLine();
                    for(Student l : record){
                        if(l.getStudentNumber().compareTo(tempString) == 0){
                            int updateChoice = 0;
                            do{
                                System.out.println("\t\tUpdate Menu\n\t1. Change first name\n\t2. Change middle initial\n\t3. Change last name\n\t4. Change Program\n\t5. Change year level\n\t6. I'm finished");
                                updateChoice = in.nextInt();
                                switch(updateChoice){
                                    case 1:
                                        System.out.println("Enter name: ");
                                        l.setFirstName(ln2.nextLine());
                                        break;
                                    case 2:
                                        System.out.println("Enter initial: ");
                                        l.setMiddleInitial(ln2.nextLine().charAt(0));
                                        break;
                                    case 3:
                                        System.out.println("Enter name: ");
                                        l.setLastName(ln2.nextLine());
                                        break;
                                    case 4:
                                        System.out.println("Enter course: ");
                                        l.setCourse(ln2.nextLine());
                                        break;
                                    case 5:
                                        System.out.println("Enter year: ");
                                        l.setYearLevel(ln2.nextInt());
                                        break;
                                    case 6:
                                        break;
                                    default:
                                        System.out.println("Invalid");
                                }
                                System.out.println(l);
                            }while(updateChoice != 6);
                            System.out.println("Necessary fields changed.");
                        }
                    }

                    break;
                case 7:
                    System.out.println("Exiting..\n");
                    break;
                default:
                    System.out.print("Invalid Choice\n");
            }
        } while(choice != 7);
    }

    public static void display(List<Student> l){
        for(Student ln : l){
            System.out.println(ln);
        }
    }

}
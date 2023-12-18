package ru.mipt1c.homework.task1;

import org.junit.Assert;
import ru.mipt1c.homework.tests.task1.SingleFileStorageTest;
import ru.mipt1c.homework.tests.task1.StorageTestUtils;
import ru.mipt1c.homework.tests.task1.Student;
import ru.mipt1c.homework.tests.task1.StudentKey;

import java.io.IOException;
import java.util.Iterator;

/**
 * Created by Luba on 15.12.2023.
 */
public class Main {
    public static void main(String[] args) {
//        Storage<StudentKey, Student> store1 = new Storage<>(".");
//        store1.write(SingleFileStorageTest.KEY_1, SingleFileStorageTest.VALUE_1);
//        store1.write(SingleFileStorageTest.KEY_2, SingleFileStorageTest.VALUE_2);
//        try {
//            store1.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Iterator<StudentKey> iter = store1.readKeys();
//        StudentKey next;
//        while (iter.hasNext()) {
//            next = iter.next();
//            System.out.println(next + ": " + store1.read(next));
//        }
//        System.out.println("\n");
//
//
//        /////
//        Storage<StudentKey, Student> store2 = new Storage<>(".");
//        store2.write(SingleFileStorageTest.KEY_3, SingleFileStorageTest.VALUE_3);
//        store2.write(SingleFileStorageTest.KEY_3, SingleFileStorageTest.VALUE_2);
//        try {
//            store2.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Iterator<StudentKey> iter2 = store2.readKeys();
//        while (iter2.hasNext()) {
//            next = iter2.next();
//            System.out.println(next + ": " + store2.read(next));
//        }
    }
}

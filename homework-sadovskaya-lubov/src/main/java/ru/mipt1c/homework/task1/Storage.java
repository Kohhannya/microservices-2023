package ru.mipt1c.homework.task1;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Luba on 15.12.2023.
 */
public class Storage<K, V> implements KeyValueStorage<K, V> {
    private HashMap<K, V> map = new HashMap<>();
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private FileInputStream fis;
    private FileOutputStream fos;
    private final File dir;
    private File file;
    private boolean closed;

    public Storage(String filePath) {
        this.dir = new File(filePath);
        this.closed = false;

        if (!dir.exists()) {
            this.dir.mkdir();
        }
        this.file = new File(filePath + "\\students_storage.tmp");

        if (file.exists()) {
            try {
                readFromFile();
            } catch (Exception e) {
                throw new MalformedDataException();
            }
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void readFromFile() throws IOException, ClassNotFoundException {
        MyPair<K, V> next;

        //Создаём потоки чтения из файла
        this.fis = new FileInputStream(file);
        this.ois = new ObjectInputStream(fis);

        //Считываем объекты из файла, пока можем
        while (fis.available() != 0) {
            next = (MyPair<K, V>) ois.readObject();

            map.put(next.key, next.value);
        }

        fis.close();
        ois.close();
    }

    @Override
    public V read(K key) { //Значение по ключу
        if (closed) {
            throw new IllegalStateException("Storage is closed");
        }
        return map.get(key);
    }

    @Override
    public boolean exists(K key) { //Наличие ключа
        return read(key) != null;
    }

    @Override
    public void write(K key, V value) { //Добавление записи
        if (closed) {
            throw new IllegalStateException("Storage is closed");
        }
        map.put(key, value);

    }

    @Override
    public void delete(K key) { //Удаление записи
        map.remove(key);
    }

    @Override
    public Iterator<K> readKeys() { //Список ключей
        if (closed) {
            throw new IllegalStateException("Storage is closed");
        }
        return map.keySet().iterator();
    }

    @Override
    public int size() { //Кол-во записей в хранилище
        return map.size();
    }

    @Override
    public void close() throws IOException { //Закрытие хранилища и запись в файл
        //Заменяем файл новым
        file.delete();
        file.createNewFile();

        //Создаём потоки вывода в пустой файл
        fos = new FileOutputStream(file);
        oos = new ObjectOutputStream(fos);

        //Проходимся по всей Map и записываем в файлик
        Iterator<K> iter = readKeys();
        while (iter.hasNext()) {
            K key = iter.next();
            V value = read(key);
            oos.writeObject(new MyPair<>(key, value));
        }

        fos.close();
        oos.close();
        this.closed = true;
    }
}


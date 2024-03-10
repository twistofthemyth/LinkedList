package nay.kirill.generics.linkedList;

import org.junit.jupiter.api.Test;

public class LinkedListTest {

    @Test
    public void checkSizeIncrease() {
        LinkedList<String> list = new LinkedList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");

        assert list.size() == 3;
    }

    @Test
    public void checkGetByIndex() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(3);
        list.add(6);
        list.add(8);
        list.add(12);
        list.add(345);

        assert list.get(0) == 3;
        assert list.get(1) == 6;
        assert list.get(2) == 8;
        assert list.get(3) == 12;
        assert list.get(4) == 345;
    }

    @Test
    public void addSubtype() {
        LinkedList<TestElement> list = new LinkedList<>();
        list.add(new TestElement(10));
        list.add(new TestElementSubclass(11));

        assert list.get(0).getValue() == 10;
        assert list.get(1).getValue() == 110;
    }

    @Test
    public void checkSizeDecrease() {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(5);
        list.add(9);
        list.add(12);
        list.add(15);
        list.add(345655);

        list.remove(12);
        list.remove(9);

        assert list.size() == 3;
    }

    @Test
    public void checkElementIsRemoved() {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(5);
        list.add(9);
        list.add(12);
        list.add(15);
        list.add(345655);

        list.remove(12);
        list.remove(9);

        assert list.get(0) == 5;
        assert list.get(1) == 15;
        assert list.get(2) == 345655;
    }

    @Test
    public void mergeTwoLinkedList() {
        LinkedList<Integer> firstList = new LinkedList<>();
        LinkedList<Integer> secondList = new LinkedList<>();

        firstList.add(5);
        firstList.add(9);
        firstList.add(12);

        secondList.add(45);
        secondList.add(21);

        firstList.addAll(secondList);

        assert firstList.get(0) == 5;
        assert firstList.get(1) == 9;
        assert firstList.get(2) == 12;
        assert firstList.get(3) == 45;
        assert firstList.get(4) == 21;

        assert firstList.size() == 5;
    }

    @Test
    public void mergeTwoLinkedListOfSubtype() {
        LinkedList<TestElement> firstList = new LinkedList<>();
        LinkedList<TestElementSubclass> secondList = new LinkedList<>();

        firstList.add(new TestElement(4));
        firstList.add(new TestElement(43));
        firstList.add(new TestElement(90));

        secondList.add(new TestElementSubclass(21));
        secondList.add(new TestElementSubclass(91));

        firstList.addAll(secondList);

        assert firstList.get(0).getValue() == 4;
        assert firstList.get(1).getValue() == 43;
        assert firstList.get(2).getValue() == 90;
        assert firstList.get(3).getValue() == 210;
        assert firstList.get(4).getValue() == 910;

        assert firstList.size() == 5;
    }

    private static class TestElement {

        TestElement(int value) {
            this.value = value;
        }

        private final int value;

        public int getValue() {
            return value;
        }
    }

    private static class TestElementSubclass extends TestElement {

        TestElementSubclass(int value) {
            super(value);
        }

        @Override
        public int getValue() {
            return super.getValue() * 10;
        }
    }

}

package com.test.pattern.abstractfactory;


interface Chair {

    String getType();

    boolean hasFourLegs();

    boolean canLeanYourBack();

}

class VintageChair implements Chair {

    public String getType() {
        return "Mordern Chair";
    }

    @Override
    public boolean hasFourLegs() {
        return true;
    }

    @Override
    public boolean canLeanYourBack() {
        return true;
    }
}

class MordernChair implements Chair {

    public String getType() {
        return "Mordern Chair";
    }

    @Override
    public boolean hasFourLegs() {
        return true;
    }

    @Override
    public boolean canLeanYourBack() {
        return true;
    }
}

interface Table {

    String getTableType();

    boolean hasFourLegs();

    boolean canPutStuffOnIt();
}

class VintageTable implements Table {

    @Override
    public String getTableType() {
        return "Vintage Table";
    }

    @Override
    public boolean hasFourLegs() {
        return true;
    }

    @Override
    public boolean canPutStuffOnIt() {
        return true;
    }
}

class MordernTable implements Table {

    @Override
    public String getTableType() {
        return "Mordern Table";
    }

    @Override
    public boolean hasFourLegs() {
        return true;
    }

    @Override
    public boolean canPutStuffOnIt() {
        return true;
    }
}


interface FurnitureFactory {
    Chair createChair();

    Table createTable();
}


class MordernFurnitureFactory implements FurnitureFactory {

    @Override
    public Chair createChair() {
        return new MordernChair();
    }

    @Override
    public Table createTable() {
        return new MordernTable();
    }
}

class VintageFurnitureFactory implements FurnitureFactory {

    @Override
    public Chair createChair() {
        return new VintageChair();
    }

    @Override
    public Table createTable() {
        return new VintageTable();
    }
}

class FurnitureLot {
    final Chair chair;
    final Table table;

    FurnitureLot(Chair chair, Table table) {
        this.chair = chair;
        this.table = table;
    }

    @Override
    public String toString() {
        return "FurnitureLot{" +
                "chair=" + chair.getType() +
                ", table=" + table.getTableType() +
                '}';
    }
}


class CreatorClass {

    private FurnitureFactory furnitureFactory;

    public CreatorClass(FurnitureFactory furnitureFactory) {
        this.furnitureFactory = furnitureFactory;
    }


    FurnitureLot deliverLot() {
        return new FurnitureLot(furnitureFactory.createChair(), furnitureFactory.createTable());
    }


}

public class AbstractFactoryImpl {

    public static void main(String[] args) {
        VintageFurnitureFactory vintageFurnitureFactory = new VintageFurnitureFactory();
        MordernFurnitureFactory mordernFurnitureFactory = new MordernFurnitureFactory();
        CreatorClass creatorClass = new CreatorClass(vintageFurnitureFactory);
        System.out.println(creatorClass.deliverLot());
        creatorClass = new CreatorClass(mordernFurnitureFactory);
        System.out.println(creatorClass.deliverLot());
    }

}

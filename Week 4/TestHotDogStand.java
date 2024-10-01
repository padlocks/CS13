class TestHotDogStand {
  public static void main(String[] args) {
    HotDogStand stand1 = new HotDogStand(4915734, "Folsom");
    HotDogStand stand2 = new HotDogStand(19419194, "Rocklin");
    HotDogStand stand3 = new HotDogStand(63633236, "Auburn");

    // ordering hot dogs at different stand
    stand1.order(100);
    stand2.order(150);
    stand3.order(175);

    // getting the total number of the hotdogs ordered at all the stations
    int total = stand1.getCountSold() + stand2.getCountSold() +
        stand3.getCountSold();
    double totalIncome = stand1.netIncome() + stand2.netIncome() + stand3.netIncome();
    // displaying the info
    System.out.println(stand1);
    System.out.println("_______________________________________________");
    System.out.println(stand2);
    System.out.println("_______________________________________________");
    System.out.println(stand3);
    System.out.println("________________________________________________");
    System.out.println("Total hotdogs sold at all the stations: " + total);
    System.out.println("________________________________________________");
    System.out.println("Total income: " + totalIncome);
  }
}
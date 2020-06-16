package com.javarush.task.task19.task1901;

public class Solution {

    /*TableAdapter
      Измени класс TableAdapter так, чтобы он адаптировал ATable к BTable.
      Метод getHeaderText должен возвращать такую строку "[username] : tablename".
      Пример, "[Amigo] : DashboardTable".
    */

        public static void main(String[] args) {

            //это пример вывода
            ATable aTable = new ATable() {

                @Override
                public String getCurrentUserName() {
                    return "Amigo";
                }

                @Override
                public String getTableName() {
                    return "DashboardTable";
                }
            };

            BTable table = new TableAdapter(aTable);
            System.out.println(table.getHeaderText());
        }

        public static class TableAdapter implements BTable {
            private  ATable aTable;
            TableAdapter(ATable aTable) {
                this.aTable = aTable;
            }

            @Override
            public String getHeaderText() {
                String nameTable = aTable.getTableName();
                String nameUser = aTable.getCurrentUserName();
                return "[" + nameUser + "]" + " : " + nameTable;
            }
        }

        public interface ATable {

            String getCurrentUserName();
            String getTableName();
        }

        public interface BTable {

            String getHeaderText();
        }
}


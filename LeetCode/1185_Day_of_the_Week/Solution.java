class Solution {
    String[] weekDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    public String dayOfTheWeek(int day, int month, int year) {
        int weekDay = 5; // friday

        int d = 1, m = 1, y = 1971;

        while(!(d == day && m == month && y == year))
        {
            d++;
            weekDay = (weekDay + 1) % 7;

            if(d > daysOfMonth(m,y))
            {
                d = 1;
                m++;

                if(m > 12)
                {
                    m = 1;
                    y++;
                }
            }

        }
                    return weekDays[weekDay];

    }

    public int daysOfMonth(int month, int year){
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if(month == 2 && leaf(year))
            return 29;

        return days[month - 1];

    }

    public boolean leaf(int y)
    {
        return (y % 400 == 0) || ((y % 4 == 0) && (y % 100 != 0));
    }
}
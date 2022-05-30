public enum Planet
{
    Mercury(1,0,500, null),
    Venus(2,500,  1000, Mercury),
    Earth(3,1000,  1500, Venus),
    Mars(4,1500, 2000, Earth),
    Jupiter(5,2000, 2500, Mars),
    Saturn(6,2500,3000, Jupiter),
    Uranus(7,3000, 3500, Saturn),
    Neptune(8,3500, 4000, Uranus);

    int numberFromSun; //номер по порядку от солнца (для спутников применяется номер планеты)
    int distanceFromPrevPlanet; //удаленность от предыдущей планеты (для меркурия 0)
    int distanceFromSun; //удаленность от солнца
    int radius; //радиус
    Planet previous; //предыдущая планета
    Planet next; //следующая планета
    int minimalDistanceFromSun = 1000;

    Planet (int numberFromSun,int distanceFromPrevPlanet,int radius, Planet previous)
    {
        this.numberFromSun = numberFromSun;
        this.distanceFromPrevPlanet = distanceFromPrevPlanet;
        //this.distanceFromSun = distanceFromSun;
        this.radius = radius;

        if(previous != null)
        {
            previous.next = this;
        }
        Distance();
    }
    public void Distance()

    {
        if (distanceFromPrevPlanet == 0)
        {
        distanceFromSun = minimalDistanceFromSun;
        }
        else
        {
        distanceFromSun = distanceFromPrevPlanet + minimalDistanceFromSun;
        }
    }

}

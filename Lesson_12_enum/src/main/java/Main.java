public class Main
{
    private static Planet p;
    public static void main(String[] args)
    {
       showPlanet(Planet.Jupiter);
    }
    public static void showPlanet(Planet planet)
    {
        System.out.println(planet);
        System.out.println(planet.distanceFromSun);
    }
}

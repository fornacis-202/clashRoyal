package sample;

import javafx.geometry.Point2D;

import java.util.ArrayList;

/**
 * The type Component generator.
 */
public class ComponentGenerator {
    private static final int distance=10;

    /**
     * Generate array list.
     *
     * @param role     the role
     * @param position the position
     * @param level    the level
     * @param count    the count
     * @return the array list
     */
    public static ArrayList<Component> generate(Role role, Point2D position, int level, int count){
        ArrayList<Component> components = new ArrayList<>();
        if(role.equals(Role.BARBARIAN)){
            int HP=47*level + 241;
            int damage = 8 * level + 65;

            for (int i=0;i<count;i++){
                Point2D position1=new Point2D(position.getX(),position.getY()+distance*i);
                components.add(new GroundSoldier(position1,1.2,Role.BARBARIAN,1.5,HP,damage,Ground.class,false,Speed.MEDIUM));
            }

        }else if(role.equals(Role.ARCHER)){
            int HP=15*level + 104;
            int damage = 6 * level + 29;

            for (int i=0;i<count;i++){
                Point2D position1=new Point2D(position.getX(),position.getY()+distance*i);
                components.add(new GroundSoldier(position1,5,Role.ARCHER,1.2,HP,damage,Force.class,false,Speed.MEDIUM));
            }

        }
        else if(role.equals(Role.DRAGON)){
            int HP=92*level + 700;
            int damage = 11 * level + 87;

            for (int i=0;i<count;i++){
                Point2D position1=new Point2D(position.getX(),position.getY()+distance*i);
                components.add(new AirSoldier(position1,3,Role.DRAGON,1.8,HP,damage,Force.class,true,Speed.FAST));
            }

        }else if(role.equals(Role.WIZARD)){
            int HP=39*level + 297;
            int damage = 15* level + 114;

            for (int i=0;i<count;i++){
                Point2D position1=new Point2D(position.getX(),position.getY()+distance*i);
                components.add(new GroundSoldier(position1,5,Role.WIZARD,1.7,HP,damage,Force.class,true,Speed.MEDIUM));
            }

        }else if(role.equals(Role.PEKKA)){
            int HP=69*level + 525;
            int damage = 37 * level + 274;

            for (int i=0;i<count;i++){
                Point2D position1=new Point2D(position.getX(),position.getY()+distance*i);
                components.add(new GroundSoldier(position1,1.2,Role.PEKKA,1.8,HP,damage,Ground.class,false,Speed.FAST));
            }

        }else if(role.equals(Role.GIANT)){
            int HP=230*level + 1750;
            int damage = 14 * level + 110;

            for (int i=0;i<count;i++){
                Point2D position1=new Point2D(position.getX(),position.getY()+distance*i);
                components.add(new GroundSoldier(position1,1.2,Role.GIANT,1.5,HP,damage,DefenseBuilding.class,false,Speed.SLOW));
            }

        }
        else if(role.equals(Role.VALKYRIE)){
            int HP=101*level + 770;
            int damage = 14 * level + 105;

            for (int i=0;i<count;i++){
                Point2D position1=new Point2D(position.getX(),position.getY()+distance*i);
                components.add(new GroundSoldier(position1,2.5,Role.VALKYRIE,1.5,HP,damage,Ground.class,true,Speed.MEDIUM));
            }

        }
        else if(role.equals(Role.RAGE)){
            double duration=0.5*level + 5.5;
            for (int i=0;i<count;i++){
                Point2D position1=new Point2D(position.getX(),position.getY()+distance*i);
                components.add(new Spell(position1,5,Role.RAGE,0.4,duration));
            }

        }
        else if(role.equals(Role.FIRE_BALL)){
            double parameter=38*level + 284;
            for (int i=0;i<count;i++){
                Point2D position1=new Point2D(position.getX(),position.getY()+distance*i);
                components.add(new Spell(position1,2,Role.FIRE_BALL,parameter, 3.0));
            }

        }
        else if(role.equals(Role.ARROW)){
            double parameter=16*level + 125;
            for (int i=0;i<count;i++){
                Point2D position1=new Point2D(position.getX(),position.getY()+distance*i);
                components.add(new Spell(position1,4,Role.ARROW,parameter, 3.0));
            }

        }
        else if(role.equals(Role.CANNON)){
            int HP=43*level + 332;
            int damage = 7 * level + 52;

            for (int i=0;i<count;i++){
                Point2D position1=new Point2D(position.getX(),position.getY()+distance*i);
                components.add(new DefenseBuilding(position1,5,Role.CANNON,0.8,HP,damage,Ground.class,false,30.0));
            }

        }
        else if(role.equals(Role.INFERNO)){
            int HP=92*level + 700;
            int damage = 6* level + 50;

            for (int i=0;i<count;i++){
                Point2D position1=new Point2D(position.getX(),position.getY()+distance*i);
                components.add(new DefenseBuilding(position1,6,Role.INFERNO,0.4,HP,damage,Force.class,false,40.0));
            }

        }
        else if(role.equals(Role.KING_TOWER)){
            int HP=172*level + 2222;
            int damage = 4 * level + 46;

            for (int i=0;i<count;i++){
                Point2D position1=new Point2D(position.getX(),position.getY()+distance*i);
                components.add(new DefenseBuilding(position1,7,Role.KING_TOWER,1.0,HP,damage,Force.class,false,null));
            }

        }
        else if(role.equals(Role.ARCHER_TOWER)){
            int HP=122*level + 1269;
            int damage = 5 * level + 44;

            for (int i=0;i<count;i++){
                Point2D position1=new Point2D(position.getX(),position.getY()+distance*i);
                components.add(new DefenseBuilding(position1,8,Role.ARCHER_TOWER,0.8,HP,damage,Force.class,false,null));
            }

        }

        return components;
    }
}

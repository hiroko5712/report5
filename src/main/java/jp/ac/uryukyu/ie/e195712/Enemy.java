package jp.ac.uryukyu.ie.e195712;

/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Enemy extends LivingThing {
    private int hitpoint;
    public Enemy ( String name, int maximumHP, int attack) {
        super( name, maximumHP, attack);
        hitpoint = maximumHP;
    }

    @Override
    public void wounded(int damage) {
        setHitPoint(hitpoint);
        hitpoint -= damage;
        if( hitpoint < 0 ) {
            setDead(true);
            System.out.printf("モンスター%sは倒れた。\n", getName());
        }
    }
}
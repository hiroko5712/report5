package jp.ac.uryukyu.ie.e195712;


/**
 * ヒーローorモンスタークラス。
 *  String name; //名前
 *  int hitPoint; //HP
 *  int attack; //攻撃力
 *  boolean dead; //生死状態。true=死亡。
 */
public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    public void setHitPoint( int hitPoint ) {this.hitPoint = hitPoint;}
    public int getHitPoint() { return hitPoint; }

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name ヒーローorモンスター名
     * @param maximumHP ヒーローorモンスターのHP
     * @param attack ヒーローorモンスターの攻撃力
     */
    public LivingThing ( String name, int maximumHP, int attack ) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
    }

    //boolean型のgetterはgetではなくisがつく

    /**
     * メソッド。deadが保存している結果(trueかfalse)をゲットする。
     * boolean型のgetter。
     * @return true or false
     */
    public boolean isDead() { return dead; }
    public void setDead( boolean dead ) {this.dead =dead;}

    public String getName() { return name; }

    
    /**
     * 相手へ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * @param opponent 攻撃対象
     */
    public void attack(LivingThing opponent) {
        int damage = (int)( Math.random() * attack );
        if ( !dead ) {
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }
}

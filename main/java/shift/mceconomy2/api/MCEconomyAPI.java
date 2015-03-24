package shift.mceconomy2.api;

import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import shift.mceconomy2.api.shop.IProductList;
import shift.mceconomy2.api.shop.IShopManager;
import shift.mceconomy2.api.shop.ProductList;

/**
 * MCEconomyのAPI <br>
 * MCEconomyとのやりとりはこのClassのメソッドを使用する(他の場合は互換性の保証が出来ない)
 * @since 1.0.0
 * @version 2.0.0
 * @author Shift02
 */
public class MCEconomyAPI {

	public static IMPManager MPManager ;

	public static ISoundManager SoundManager ;

	public static IShopManager ShopManager ;

	static{
		//registerPurchaseItem();
	}

	/*
	 *--------------------------------------
	 *  Minecraft Point
	 *--------------------------------------
	 */

	/**
	 * addPlayerMP 指定したプレイヤーのMPを追加
	 * @param entityPlayer MPを追加するプレイヤー
	 * @param amount MPの額
	 * @return 実際に追加できたMPの額
	 */
	public static int addPlayerMP(EntityPlayer entityPlayer, int amount, boolean simulation){
		return MPManager.addPlayerMP(entityPlayer, amount,simulation);
	}

	/**
	 * reducePlayerMP 指定したプレイヤーのMPを削減
	 * @param entityPlayer MPを削減するプレイヤー
	 * @param amount MPの額
	 * @return 実際に削減できたMPの額
	 */
	public static int reducePlayerMP(EntityPlayer entityPlayer, int amount, boolean simulation){
		return MPManager.reducePlayerMP(entityPlayer, amount,simulation);
	}

	/**
	 * setPlayerMP  指定したプレイヤーのMPを設定
	 * @param entityPlayer MPを設定するプレイヤー
	 * @param amount MPの額
	 */
	public static void setPlayerMP(EntityPlayer entityPlayer, int amount){
		MPManager.setPlayerMP(entityPlayer, amount);
	}

	/**
	 * getPlayerMP 指定したプレーヤーの所持金額を返す
	 * @param entityPlayer MPを所持するプレイヤー
	 * @return プレイヤーの所持しておるMP量
	 */
	public static int getPlayerMP(EntityPlayer entityPlayer){
		return MPManager.getPlayerMP(entityPlayer);
	}

	//廃止
	/**
	 * printChatMPMessage 指定したプレーヤーの所持金額をチャット欄に表示
	 * @param entityPlayer MPを所持するプレイヤー
	 */
	@Deprecated
	public static void printChatMPMessage(EntityPlayer entityPlayer){
		//MPManager.printChatMPMessage(entityPlayer);
	}

	//未実装
	/**
	 * spawnWorldMP ワールドにMPコインをスポーンさせる(未実装)
	 * @param world ワールド
	 * @param x x軸
	 * @param y y軸
	 * @param z z軸
	 * @param amount MPの額
	 */
	@Deprecated
	public static void spawnWorldMP(World world, int x, int y, int z, int amount){
		//MPManager.spawnWorldMP(world, x, y, z, amount);
	}

	/*
	 *--------------------------------------
	 *  Shop
	 *--------------------------------------
	 */
	/**
	 * registerProductList IProductListを実装したClassを登録
	 * @param list 商品リスト <br>{@link ProductList}  を使うと便利です
	 * @see IProductList
	 * @return ShopID
	 */
	public static int registerProductList(IProductList list){
		//return ShopManager.registerProductList(list);
		return 0;
	}

	/**
	 * getProductList ShopIDからIProductListを取得
	 * @param id ShopID
	 * @return IProductList
	 */
	public static IProductList getProductList(int id){
		return ShopManager.getProductList(id);
	}

	/**
	 * openShopGui ShopのGUIを開く
	 * @param id ShopID
	 * @param player プレイヤー
	 * @param world ワールド
	 * @param x x軸
	 * @param y y軸
	 * @param z z軸
	 */
	public static void openShopGui(int id, EntityPlayer player, World world, int x, int y, int z){
		ShopManager.openShopGui(id, player, world, x, y, z);
	}

	/**
	 * addPurchaseItem Mobなどがアイテムを買い取る価格を登録
	 * @param PurchaseItem 買い取りアイテム
	 * @param amount 価格  -1で非売品に設定出来ます
	 */
	public static void addPurchaseItem(ItemStack PurchaseItem, int amount){
		ShopManager.addPurchaseItem(PurchaseItem, amount);
	}

	/**
	 * getPurchase アイテムの買い取り額を取得
	 * @param item 売るアイテム
	 * @return 価格
	 */
	public static int getPurchase(ItemStack item){
		return ShopManager.getPurchase(item);
	}

	/**
	 * hasPurchase アイテムに価格が設定されているか
	 * @param item 調べるアイテム
	 * @return 設定されていればtrue 非売品はfalseになります.
	 */
	public static boolean hasPurchase(ItemStack item) {
		return ShopManager.hasPurchase(item);
	}

	/**
	 * addPurchaseItem Mobなどが流体を買い取る価格を登録
	 * @param PurchaseItem 買い取る流体
	 * @param amount 価格(1mB)  -1で非売品に設定出来ます
	 */
	public static void addPurchaseFluid(Fluid fluid, double mp){
		ShopManager.addPurchaseFluid(fluid, mp);
	}

	/**
	 * getPurchase 流体の買い取り額を取得
	 * @param item 売る流体
	 * @return 価格(1mB)
	 */
	public static double getFluidPurchase(Fluid fluid){
		return ShopManager.getFluidPurchase(fluid);
	}

	/**
	 * hasPurchase 流体に価格が設定されているか
	 * @param item 調べる流体
	 * @return 設定されていればtrue 非売品はfalseになります.
	 */
	public static boolean hasFluidPurchase(Fluid fluid) {
		return ShopManager.hasFluidPurchase(fluid);
	}

	/**
	 * registerPurchaseItem API読み込み時にバニラアイテムの価格が自動で設定される。
	 * 時間がかかりそうなので手をつけてない。
	 * 少し手をつけた
	 */
	public static void registerPurchaseItem(){

		//MCEconomyAPI.ShopManager = new ShopManager();


		addPurchaseItem(new ItemStack(Blocks.stone), 0);
		addPurchaseItem(new ItemStack(Blocks.grass), 2);
		addPurchaseItem(new ItemStack(Blocks.dirt), 0);
		addPurchaseItem(new ItemStack(Blocks.cobblestone), 0);
		addPurchaseItem(new ItemStack(Blocks.planks,1,0), 0);
		addPurchaseItem(new ItemStack(Blocks.planks,1,1), 0);
		addPurchaseItem(new ItemStack(Blocks.planks,1,2), 0);
		addPurchaseItem(new ItemStack(Blocks.planks,1,3), 0);
		addPurchaseItem(new ItemStack(Blocks.sapling), 0);
		addPurchaseItem(new ItemStack(Blocks.bedrock), 1000);
		//addPurchaseItem(new ItemStack(Blocks.waterMoving), -1);
		//addPurchaseItem(new ItemStack(Blocks.waterStill), -1);
		//addPurchaseItem(new ItemStack(Blocks.lavaMoving), -1);
		//addPurchaseItem(new ItemStack(Blocks.lavaStill), -1);
		addPurchaseItem(new ItemStack(Blocks.sand), 0);
		addPurchaseItem(new ItemStack(Blocks.gravel), 1);
		addPurchaseItem(new ItemStack(Blocks.gold_ore), 100);
		addPurchaseItem(new ItemStack(Blocks.iron_ore), 20);
		addPurchaseItem(new ItemStack(Blocks.coal_ore), 10);
		for(int i=0;i<4;i++){
			addPurchaseItem(new ItemStack(Blocks.planks,1,i), 2);
		}
		//addPurchaseItem(new ItemStack(Blocks.wooden_pressure_plate,1,0), 2);
		//addPurchaseItem(new ItemStack(Blocks.wood,1,1), 2);
		//addPurchaseItem(new ItemStack(Blocks.wood,1,2), 2);
		//addPurchaseItem(new ItemStack(Blocks.wood,1,3), 2);
		addPurchaseItem(new ItemStack(Blocks.leaves), 0);
		addPurchaseItem(new ItemStack(Blocks.sponge), -1);
		addPurchaseItem(new ItemStack(Blocks.glass), 3);

		addPurchaseItem(new ItemStack(Blocks.lapis_ore), 80);
		addPurchaseItem(new ItemStack(Blocks.lapis_block), 20);
		addPurchaseItem(new ItemStack(Blocks.dispenser), -1);
		addPurchaseItem(new ItemStack(Blocks.sandstone), 1);
		addPurchaseItem(new ItemStack(Blocks.noteblock), 50);
		addPurchaseItem(new ItemStack(Blocks.bed), 10);
		addPurchaseItem(new ItemStack(Blocks.golden_rail), 24);
		addPurchaseItem(new ItemStack(Blocks.detector_rail), 12);
		addPurchaseItem(new ItemStack(Blocks.sticky_piston), 10);
		addPurchaseItem(new ItemStack(Blocks.web), 40);
		addPurchaseItem(new ItemStack(Blocks.tallgrass), 2);
		addPurchaseItem(new ItemStack(Blocks.deadbush), 3);
		addPurchaseItem(new ItemStack(Blocks.piston), 6);
		addPurchaseItem(new ItemStack(Blocks.piston_head), -1);

		//addPurchaseItem(new ItemStack(Block.cloth), 20);

		addPurchaseItem(new ItemStack(Blocks.piston_extension), -1);
		addPurchaseItem(new ItemStack(Blocks.yellow_flower), 1);
		addPurchaseItem(new ItemStack(Blocks.red_flower), 1);
		addPurchaseItem(new ItemStack(Blocks.brown_mushroom), 8);
		addPurchaseItem(new ItemStack(Blocks.red_mushroom), 7);
		addPurchaseItem(new ItemStack(Blocks.gold_block), 1800);
		addPurchaseItem(new ItemStack(Blocks.iron_block), 450);
		//疲れた(´・ω・｀)

		/*
		addPurchaseItem(new ItemStack(Block.stoneDoubleSlab), -1);
		addPurchaseItem(new ItemStack(Block.stoneSingleSlab), 0);
		addPurchaseItem(new ItemStack(Block.brick), 16);
		addPurchaseItem(new ItemStack(Block.tnt), 18);
		addPurchaseItem(new ItemStack(Block.bookShelf), 12);
		addPurchaseItem(new ItemStack(Block.cobblestoneMossy), 4);
		addPurchaseItem(new ItemStack(Block.obsidian), 8);
		addPurchaseItem(new ItemStack(Block.torchWood), -1);
		addPurchaseItem(new ItemStack(Block.fire), -1);
		addPurchaseItem(new ItemStack(Block.mobSpawner), 999);
		addPurchaseItem(new ItemStack(Block.stairsWoodOak), 3);
		addPurchaseItem(new ItemStack(Block.chest), 6);
		addPurchaseItem(new ItemStack(Block.redstoneWire), -1);
		addPurchaseItem(new ItemStack(Block.oreDiamond), 2000);
		addPurchaseItem(new ItemStack(Block.blockDiamond), 9000);
		addPurchaseItem(new ItemStack(Block.workbench), -1);
		addPurchaseItem(new ItemStack(Block.crops), -1);
		addPurchaseItem(new ItemStack(Block.tilledField), -1);
		addPurchaseItem(new ItemStack(Block.furnaceIdle), -1);
		addPurchaseItem(new ItemStack(Block.furnaceBurning), -1);
		addPurchaseItem(new ItemStack(Block.signPost), -1);
		addPurchaseItem(new ItemStack(Block.doorWood), -1);
		addPurchaseItem(new ItemStack(Block.ladder), -1);
		addPurchaseItem(new ItemStack(Block.rail), 10);
		addPurchaseItem(new ItemStack(Block.stairsCobblestone), 0);
		addPurchaseItem(new ItemStack(Block.signWall), -1);
		addPurchaseItem(new ItemStack(Block.lever), -1);
		addPurchaseItem(new ItemStack(Block.pressurePlateStone), 0);
		addPurchaseItem(new ItemStack(Block.doorIron), 0);
		addPurchaseItem(new ItemStack(Block.pressurePlatePlanks), 0);
		addPurchaseItem(new ItemStack(Block.oreRedstone), 100);
		addPurchaseItem(new ItemStack(Block.oreRedstoneGlowing), -1);
		addPurchaseItem(new ItemStack(Block.torchRedstoneIdle), -1);
		addPurchaseItem(new ItemStack(Block.torchRedstoneActive), -1);
		addPurchaseItem(new ItemStack(Block.stoneButton), -1);
		addPurchaseItem(new ItemStack(Block.snow), 2);
		addPurchaseItem(new ItemStack(Block.ice), 6);
		addPurchaseItem(new ItemStack(Block.blockSnow), 0);
		addPurchaseItem(new ItemStack(Block.cactus), 1);
		addPurchaseItem(new ItemStack(Block.blockClay), 42);
		addPurchaseItem(new ItemStack(Block.reed), -1);
		addPurchaseItem(new ItemStack(Block.jukebox), -1);
		addPurchaseItem(new ItemStack(Block.fence), 2);
		addPurchaseItem(new ItemStack(Block.pumpkin), 3);
		addPurchaseItem(new ItemStack(Block.netherrack), -1);
		addPurchaseItem(new ItemStack(Block.slowSand), 7);
		addPurchaseItem(new ItemStack(Block.glowStone), 21);



		addPurchaseItem(new ItemStack(Item.ingotIron), 50);
		addPurchaseItem(new ItemStack(Item.ingotGold), 200);
		addPurchaseItem(new ItemStack(Item.diamond), 1000);*/

		/**
		 * @editor defeatedcrow
		 * @date 2014.4.15
		 * 勝手にバニラ未登録アイテム・ブロックの価格を追加。
		 * <br>無限入手手段のあるもの、かつ、安定入手の体制ができるとポコポコ増えていくものは価格を相当下げてあります。
		 * <br>また、独断により、金・ダイアの加工品（ツールと防具）は価値が半減するように致しました。
		 * <br>下記については全く同じ内容で拙作ShowCaseアドオン内でも登録されておりますが、
		 * 本体APIで登録された後は、ShowCase側での登録部分を削除いたします。
		 * */


		/**Foods and crops: 基本的に無限資源はタダ、調理するとわずかに値打ちが出る*/
		//金のりんご
		/*
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.appleGold, 1, 0), 180);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.appleGold, 1, 1), 1600);

		//生食材
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.appleRed, 1, 0), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.beefRaw, 1, 0), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.carrot, 1, 0), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.chickenRaw, 1, 0), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.fishRaw, 1, 0), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.melon, 1, 0), 0);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.porkRaw, 1, 0), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.potato, 1, 0), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.reed, 1, 0), 0);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.seeds, 1, 0), 0);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.melonSeeds, 1, 0), 0);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.pumpkinSeeds, 1, 0), 0);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.wheat, 1, 0), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.sugar, 1, 0), 0);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.poisonousPotato, 1, 0), 0);

		//調理済み
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.bakedPotato, 1, 0), 2);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.beefCooked, 1, 0), 3);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.bowlSoup, 1, 0), 3);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.bread, 1, 0), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.cake, 1, 0), 5);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.chickenCooked, 1, 0), 2);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.cookie, 1, 0), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.fishCooked, 1, 0), 2);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.porkCooked, 1, 0), 2);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.pumpkinPie, 1, 0), 2);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.goldenCarrot, 1, 0), 180);
		*/

		/**Materials: ものによる*/
		//素材
		/*
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.emerald, 1, 0), 15);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.flint, 1, 0), 3);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.netherQuartz, 1, 0), 35);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.goldNugget, 1, 0), 20);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.redstone, 1, 0), 12);

		//misc
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.brick, 1, 0), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.clay, 1, 0), 0);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.coal, 1, 0), 5);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.coal, 1, 1), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.egg, 1, 0), 0);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.feather, 1, 0), 0);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.fermentedSpiderEye, 1, 0), 3);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.fireballCharge, 1, 0), 5);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.glowstone, 1, 0), 25);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.leather, 1, 0), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.netherrackBrick, 1, 0), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.netherStalkSeeds, 1, 0), 7);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.paper, 1, 0), 0);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.snowball, 1, 0), 0);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.speckledMelon, 1, 0), 90);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.stick, 1, 0), 0);

		for (int i = 0 ; i < 16 ; i++)
		{
			if (i == 5)
			{
				MCEconomyAPI.addPurchaseItem(new ItemStack(Item.dyePowder, 1, 0), 3);
			}
			else
			{
				MCEconomyAPI.addPurchaseItem(new ItemStack(Item.dyePowder, 1, 0), 1);
			}
		}

		//モブドロップ
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.blazePowder, 1, 0), 3);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.blazeRod, 1, 0), 10);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.bone, 1, 0), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.rottenFlesh, 1, 0), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.enderPearl, 1, 0), 15);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.eyeOfEnder, 1, 0), 40);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.ghastTear, 1, 0), 120);//俗にいう金策モブ
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.gunpowder, 1, 0), 4);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.magmaCream, 1, 0), 5);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.silk, 1, 0), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.slimeBall, 1, 0), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.spiderEye, 1, 0), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.netherStar, 1, 0), 3000);//やすい。

		*/

		/**Tools: 素材の額とだいたい等価か、少し安い*/
		//ツール

		/*
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.arrow, 1, 0), 2);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.bow, 1, 0), 5);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.axeDiamond, 1, 0), 1500);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.axeGold, 1, 0), 300);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.axeIron, 1, 0), 150);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.axeStone, 1, 0), 15);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.axeWood, 1, 0), 5);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.hoeDiamond, 1, 0), 1000);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.hoeGold, 1, 0), 200);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.hoeIron, 1, 0), 100);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.hoeStone, 1, 0), 10);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.hoeWood, 1, 0), 5);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.pickaxeDiamond, 1, 0), 1800);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.pickaxeGold, 1, 0), 350);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.pickaxeIron, 1, 0), 150);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.pickaxeStone, 1, 0), 15);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.pickaxeWood, 1, 0), 5);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.shovelDiamond, 1, 0), 500);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.shovelGold, 1, 0), 100);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.shovelIron, 1, 0), 50);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.shovelStone, 1, 0), 5);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.shovelWood, 1, 0), 3);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.swordDiamond, 1, 0), 1000);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.swordGold, 1, 0), 200);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.swordIron, 1, 0), 100);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.swordStone, 1, 0), 10);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.swordWood, 1, 0), 5);

		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.book, 1, 0), 3);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.bowlEmpty, 1, 0), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.bucketEmpty, 1, 0), 150);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.bucketLava, 1, 0), 200);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.bucketMilk, 1, 0), 160);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.bucketWater, 1, 0), 150);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.carrotOnAStick, 1, 0), 8);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.compass, 1, 0), 200);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.expBottle, 1, 0), 50);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.flintAndSteel, 1, 0), 55);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.flowerPot, 1, 0), 10);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.glassBottle, 1, 0), 2);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.leash, 1, 0), 5);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.map, 1, 0), 300);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.nameTag, 1, 0), 120);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.pocketSundial, 1, 0), 800);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.saddle, 1, 0), 20);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.writableBook, 1, 0), 5);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.writtenBook, 1, 0), 5);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.shears, 1, 0), 100);

		//のりもの
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.minecartEmpty, 1, 0), 450);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.boat, 1, 0), 10);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.minecartCrate, 1, 0), 500);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.minecartHopper, 1, 0), 800);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.minecartPowered, 1, 0), 500);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.minecartTnt, 1, 0), 530);

		//設置物
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.bed, 1, 0), 10);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.brewingStand, 1, 0), 20);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.cauldron, 1, 0), 350);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.comparator, 1, 0), 100);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.redstoneRepeater, 1, 0), 25);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.doorIron, 1, 0), 250);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.doorWood, 1, 0), 8);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.itemFrame, 1, 0), 8);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.painting, 1, 0), 12);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.sign, 1, 0), 6);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.skull, 1, 0), 75);

		//防具
		//金とダイアは価値が半減する
		//ダメージ値ゼロ指定なので、たぶん新品以外は売れないはず
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.bootsChain, 1, 0), 80);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.bootsDiamond, 1, 0), 2000);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.bootsGold, 1, 0), 400);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.bootsIron, 1, 0), 200);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.bootsLeather, 1, 0), 20);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.helmetChain, 1, 0), 100);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.helmetDiamond, 1, 0), 2500);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.helmetGold, 1, 0), 500);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.helmetIron, 1, 0), 250);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.helmetLeather, 1, 0), 30);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.plateChain, 1, 0), 160);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.plateDiamond, 1, 0), 4000);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.plateGold, 1, 0), 800);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.plateIron, 1, 0), 400);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.plateLeather, 1, 0), 50);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.legsChain, 1, 0), 140);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.legsDiamond, 1, 0), 3500);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.legsGold, 1, 0), 700);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.legsIron, 1, 0), 350);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.legsLeather, 1, 0), 35);

		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.horseArmorDiamond, 1, 0), 2000);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.horseArmorGold, 1, 0), 400);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Item.horseArmorIron, 1, 0), 200);
		*/

		/**Blocks: API本体の傾向に似せる*/
		//ore

		/*
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.oreEmerald, 1, 0), 400);//エメラルドは鉱石だと金の二倍。
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.oreDiamond, 1, 0), 1500);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.oreNetherQuartz, 1, 0), 140);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.oreRedstone, 1, 0), 60);

		//Mineral block
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.blockNetherQuartz, 1, 0), 140);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.blockNetherQuartz, 1, 0), 150);//加工してるとちょっと高い
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.blockNetherQuartz, 1, 0), 150);//〃
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.blockDiamond, 1, 0), 9000);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.blockEmerald, 1, 0), 135);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.blockRedstone, 1, 0), 108);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.coalBlock, 1, 0), 45);

		//地形
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.blockClay, 1, 0), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.stoneBrick), 0);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.cactus, 1, 0), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.vine, 1, 0), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.waterlily, 1, 0), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.hardenedClay, 1, 0), 2);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.ice, 1, 0), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.blockSnow, 1, 0), 0);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.netherrack, 1, 0), 0);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.netherBrick, 1, 0), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.netherFence, 1, 0), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.slowSand, 1, 0), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.glowStone, 1, 0), 100);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.whiteStone, 1, 0), 15);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.obsidian, 1, 0), 12);

		//人工物系の地形
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.bookShelf, 1, 0), 10);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.cobblestoneMossy, 1, 0), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.cobblestoneWall, 1, 0), 0);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.fence, 1, 0), 0);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.fenceGate, 1, 0), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.fenceIron, 1, 0), 18);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.cloth, 1, 0), 4);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.furnaceIdle, 1, 0), 2);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.hay, 1, 0), 3);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.pumpkin, 1, 0), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.pumpkinLantern, 1, 0), 2);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.melon, 1, 0), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.silverfish, 1, 0), 20);//ちょっとお得
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.thinGlass, 1, 0), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.tnt, 1, 0), 10);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.workbench, 1, 0), 2);

		//設置物
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.anvil, 1, 0), 1550);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.carpet, 1, 0), 3);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.chestTrapped, 1, 0), 50);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.dispenser, 1, 0), 20);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.doorIron, 1, 0), 250);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.doorWood, 1, 0), 8);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.dropper, 1, 0), 8);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.daylightSensor, 1, 0), 110);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.enchantmentTable, 1, 0), 1200);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.enderChest, 1, 0), 150);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.endPortal, 1, 0), -1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.endPortalFrame, 1, 0), -1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.fire, 1, 0), -1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.hopperBlock, 1, 0), 250);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.ladder, 1, 0), 3);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.lever, 1, 0), 3);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.mobSpawner, 1, 0), -1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.pressurePlateGold, 1, 0), 350);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.pressurePlateIron, 1, 0), 100);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.pressurePlatePlanks, 1, 0), 2);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.pressurePlateStone, 1, 0), 5);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.redstoneLampIdle, 1, 0), 120);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.stainedClay, 1, 0), 2);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.stoneButton, 1, 0), 0);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.woodenButton, 1, 0), 0);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.torchRedstoneIdle, 1, 0), 14);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.torchWood, 1, 0), 2);
		MCEconomyAPI.addPurchaseItem(new ItemStack(Block.trapdoor, 1, 0), 2);

		*/

		//液体
		addPurchaseFluid(FluidRegistry.WATER, 0.0001);
		addPurchaseFluid(FluidRegistry.LAVA, 0.01);

		//Entity
		MCEconomyAPI.ShopManager.addPurchaseEntity(EntityZombie.class, 2);
		MCEconomyAPI.ShopManager.addPurchaseEntity(EntitySkeleton.class, 5);
		MCEconomyAPI.ShopManager.addPurchaseEntity(EntityCreeper.class, 6);
		MCEconomyAPI.ShopManager.addPurchaseEntity(EntityEnderman.class, 13);

		MCEconomyAPI.ShopManager.addPurchaseEntity(EntitySilverfish.class, 40);
		MCEconomyAPI.ShopManager.addPurchaseEntity(EntityWitch.class, 32);

		MCEconomyAPI.ShopManager.addPurchaseEntity(EntityGhast.class, 24);
		MCEconomyAPI.ShopManager.addPurchaseEntity(EntityBlaze.class, 8);
		MCEconomyAPI.ShopManager.addPurchaseEntity(EntityPigZombie.class, 6);

		MCEconomyAPI.ShopManager.addPurchaseEntity(EntityPlayer.class, -1);

		MCEconomyAPI.ShopManager.addPurchaseEntity(EntityVillager.class, 22);

		MCEconomyAPI.ShopManager.addPurchaseEntity(EntityBat.class, 300);

		MCEconomyAPI.ShopManager.addPurchaseEntity(EntityDragon.class, 7400);
		MCEconomyAPI.ShopManager.addPurchaseEntity(EntityWither.class, 3600);

	}


	/*
	 *--------------------------------------
	 *  Sound
	 *--------------------------------------
	 */
	public static void playCoinSoundEffect(World world, int x, int y, int z){
		SoundManager.playCoinSoundEffect(world, x, y, z);
	}

}

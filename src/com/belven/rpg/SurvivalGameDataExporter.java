package com.belven.rpg;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

import com.belven.rpg.crafting.CraftingDevice;
import com.belven.rpg.crafting.CraftingDeviceRecipe;
import com.belven.rpg.crafting.InProgressCrafting;
import com.belven.rpg.crafting.InstanceCraftingDevice;
import com.belven.rpg.items.Armour;
import com.belven.rpg.items.ArmourPosition;
import com.belven.rpg.items.CharacterType;
import com.belven.rpg.items.Consumable;
import com.belven.rpg.items.ConsumableData;
import com.belven.rpg.items.ConsumableType;
import com.belven.rpg.items.ContainerData;
import com.belven.rpg.items.ContainerItem;
import com.belven.rpg.items.GearType;
import com.belven.rpg.items.InputOrOutput;
import com.belven.rpg.items.InputOutputData;
import com.belven.rpg.items.InputOutputType;
import com.belven.rpg.items.Item;
import com.belven.rpg.items.ItemData;
import com.belven.rpg.items.ItemType;
import com.belven.rpg.items.Recipe;
import com.belven.rpg.items.RecipeInputOutputData;
import com.belven.rpg.items.RecipeType;
import com.belven.rpg.items.RowData;
import com.belven.rpg.mission.Loadout;
import com.belven.rpg.mission.LoadoutData;
import com.belven.rpg.mission.Mission;
import com.belven.rpg.mission.MissionContainer;
import com.belven.rpg.mission.MissionData;
import com.belven.rpg.mission.MissionItems;
import com.belven.rpg.mission.MissionLoadout;
import com.belven.rpg.mission.MissionLoadoutData;
import com.belven.rpg.mission.MissionType;
import com.belven.rpg.weapons.MeleeWeapon;
import com.belven.rpg.weapons.ProjectileWeapon;
import com.belven.rpg.weapons.ProjectileWeaponData;
import com.belven.rpg.weapons.RangedWeapon;
import com.belven.rpg.weapons.Weapon;
import com.belven.rpg.weapons.WeaponData;
import com.opencsv.CSVWriter;

public class SurvivalGameDataExporter {
	static String tablesFolder = "E:\\Unreal Projects\\SurvivalTest\\Source\\Tables";
	static String iconFolder = "Texture2D'/Game/FirstPerson/Icons/";
	static String weaponsMeshFolder = "StaticMesh'/Game/FirstPerson/Weapons/";
	static String containerMeshFolder = "StaticMesh'/Game/FirstPerson/LootBoxes/";

	static HashMap<Class<?>, TableDefinition> tableDefinitions = new HashMap<>();

	// Items
	static {

		// Weapons

		Item.CreateItem(new ItemData("Test Ammo", iconFolder + "539.539'", "", 30, ItemType.Ammo));
		ProjectileWeapon.CreateProjectileWeapon(new ItemData("Test Weapon", 1), new WeaponData(15000, 11, 0.01f, false, GearType.Weapon), 0.9995f,
				new ProjectileWeaponData("Test Ammo", 10, 0.2f, 15000));

		MeleeWeapon.CreateMeleeWeapon(new ItemData("Knife", 1), new WeaponData(400, 60, 1, false, GearType.Weapon), 300);
		MeleeWeapon.CreateMeleeWeapon(new ItemData("Axe", 1), new WeaponData(100, 100, 2, false, GearType.Weapon), 300);

		ProjectileWeapon.CreateProjectileWeapon(new ItemData("SMG", 1), new WeaponData(15000, 11, 0.2f, false, GearType.Weapon), 0.9975f, new ProjectileWeaponData("5.39", 60, 2f, 15000));
		ProjectileWeapon.CreateProjectileWeapon(new ItemData("MP5", 1), new WeaponData(18000, 22, 0.25f, false, GearType.Weapon), 0.9985f, new ProjectileWeaponData("7.62", 30, 1f, 18000));
		ProjectileWeapon.CreateProjectileWeapon(new ItemData("Pistol", 1), new WeaponData(15000, 25, 0.4f, false, GearType.Sidearm), 0.998f, new ProjectileWeaponData("5.39", 8, 0.8f, 13000));
		ProjectileWeapon.CreateProjectileWeapon(new ItemData("Sniper", 1), new WeaponData(40000, 100, 1.2f, false, GearType.Weapon), 0.9999f, new ProjectileWeaponData("7.62", 5, 2f, 30000));

		// Armour
		Armour.CreateArmour(new ItemData("Headpiece", iconFolder + "helmet.helmet'", "", 1), ArmourPosition.Head, 0);
		Armour.CreateArmour(new ItemData("Chestpiece", iconFolder + "armor.armor'", "", 1), ArmourPosition.Chest, 2);
		Armour.CreateArmour(new ItemData("Legs", iconFolder + "legs.legs'", "", 1), ArmourPosition.Legs, 1);
		Armour.CreateArmour(new ItemData("Vest", iconFolder + "vest.vest'", "", 1), ArmourPosition.Vest, 1);

		// Military Armour
		Armour.CreateArmour(new ItemData("Military Headpiece", iconFolder + "helmet.helmet'", "", 1), ArmourPosition.Head, 0, 10);
		Armour.CreateArmour(new ItemData("Military Chestpiece", iconFolder + "armor.armor'", "", 1), ArmourPosition.Chest, 2, 10);
		Armour.CreateArmour(new ItemData("Military Legs", iconFolder + "legs.legs'", "", 1), ArmourPosition.Legs, 1, 10);
		Armour.CreateArmour(new ItemData("Military Vest", iconFolder + "vest.vest'", "", 1), ArmourPosition.Vest, 1, 10);

		// Resources
		Item.CreateItem(new ItemData("Wood", iconFolder + "wood.wood'", "", 10));
		Item.CreateItem(new ItemData("Nails", iconFolder + "nails.nails'", "", 100));
		Item.CreateItem(new ItemData("Cloth", iconFolder + "Cloth.Cloth'", "", 20));
		Item.CreateItem(new ItemData("Barricade", iconFolder + "Barricade.Barricade'", "", 1));
		Item.CreateItem(new ItemData("Metal", iconFolder + "Metal.Metal'", "", 10));
		Item.CreateItem(new ItemData("Gunpowder", iconFolder + "Gunpowder.Gunpowder'", "", 100));
		Item.CreateItem(new ItemData("Iron Ingot", iconFolder + "Iron.Iron'", "", 100));

		// Ammo
		Item.CreateItem(new ItemData("7.62", iconFolder + "762.762'", "", 100, ItemType.Ammo));
		Item.CreateItem(new ItemData("5.39", iconFolder + "539.539'", "", 100, ItemType.Ammo));

		// Consumables
		Consumable.CreateConsumable(new ItemData("Bandage", iconFolder + "bandage.bandage'", "", 5), new ConsumableData(ConsumableType.Medical, 20));
		Consumable.CreateConsumable(new ItemData("First Aid Kit", iconFolder + "FirstAidKit.FirstAidKit'", "", 5), new ConsumableData(ConsumableType.Medical, 50));
		Consumable.CreateConsumable(new ItemData("Soda", iconFolder + "soda.soda'", "", 100), new ConsumableData(ConsumableType.Drink, 20));
		Consumable.CreateConsumable(new ItemData("Sandwich", iconFolder + "sandwich.sandwich'", "", 5), new ConsumableData(ConsumableType.Food, 20));
		Consumable.CreateConsumable(new ItemData("Bread", iconFolder + "Bread.Bread'", "", 1), new ConsumableData(ConsumableType.Food, 60));
		Consumable.CreateConsumable(new ItemData("Raw Meat", iconFolder + "Raw_Meat.Raw_Meat'", "", 5), new ConsumableData(ConsumableType.Food, -10));
		Consumable.CreateConsumable(new ItemData("Raw Veg", iconFolder + "Raw_Veg.Raw_Veg'", "", 5), new ConsumableData(ConsumableType.Food, 10));
	}

	// Loadouts
	static {
		int health = 100;
		Loadout.CreateLoadout(new LoadoutData("Test AI", "Test Weapon", "", "Chestpiece", "", "Legs", health, 800, CharacterType.Enemy));
		Loadout.CreateLoadout(new LoadoutData("Player", "MP5", "", "Chestpiece", "", "Legs", health * 10000, 1600, CharacterType.Player));
		Loadout.CreateLoadout(new LoadoutData("AI Base", "SMG", "Headpiece", "Chestpiece", "", "Legs", health, 800, CharacterType.Enemy));

		// Medical Loadouts
		Loadout.CreateLoadout(new LoadoutData("Medical Staff", "Pistol", "", "Chestpiece", "", "Legs", health, 800, CharacterType.Enemy));
		Loadout.CreateLoadout(new LoadoutData("Medical Guards", "MP5", "", "Military Chestpiece", "Military Vest", "Military Legs", health, 800, CharacterType.Enemy));
		Loadout.CreateLoadout(new LoadoutData("Medical Guards B", "SMG", "", "Chestpiece", "Vest", "Military Legs", health, 800, CharacterType.Enemy));
		Loadout.CreateLoadout(new LoadoutData("Sniper Guard", "Sniper", "Military Headpiece", "Chestpiece", "Vest", "Military Legs", health, 800, CharacterType.Enemy));
		Loadout.CreateLoadout(new LoadoutData("Doctor", "Knife", "", "", "", "Legs", health, 800, CharacterType.Enemy));

		Loadout.CreateLoadout(new LoadoutData("Civillian", "Pistol", "", "Chestpiece", "", "Legs", health, 800, CharacterType.Enemy));
		Loadout.CreateLoadout(new LoadoutData("Civillian Guard A", "MP5", "", "Chestpiece", "", "Legs", health, 800, CharacterType.Enemy));
		Loadout.CreateLoadout(new LoadoutData("Civillian Guard B", "SMG", "", "Chestpiece", "Vest", "Military Legs", health, 800, CharacterType.Enemy));

		Loadout.CreateLoadout(new LoadoutData("Military Sniper", "Sniper", "Military Headpiece", "Chestpiece", "", "Legs", health, 800, CharacterType.Enemy));
		Loadout.CreateLoadout(new LoadoutData("Military Assault", "MP5", "Military Headpiece", "Military Chestpiece", "Military Vest", "Military Legs", health, 800, CharacterType.Enemy));
		Loadout.CreateLoadout(new LoadoutData("Military Support", "SMG", "Military Headpiece", "Military Chestpiece", "Military Vest", "Military Legs", health, 800, CharacterType.Enemy));
	}

	static String SuppliesCrate = "Supplies Crate";
	static String medicalCase = "Medical Case";
	static String medicalSupplies = "Medical Supplies";
	static String militaryCrate = "Military Crate";
	static String secretCrate = "Secret Crate";
	static String lunchBox = "Lunch Box";

	// Containers
	static {
		ContainerData.CreateContainerData(0, "Zero Base", "");
		ContainerData.CreateContainerData(5, "Five base", "");
		ContainerData.CreateContainerData(10, "Ten base", "");
		ContainerData.CreateContainerData(25, "Character Inventory", "");

		ContainerData.CreateContainerData(20, SuppliesCrate, containerMeshFolder + "Crate.Crate'");
		ContainerData.CreateContainerData(5, medicalCase, containerMeshFolder + "Medical_Case.Medical_Case'");
		ContainerData.CreateContainerData(15, medicalSupplies, containerMeshFolder + "Medical_Supplies.Medical_Supplies'");
		ContainerData.CreateContainerData(15, militaryCrate, containerMeshFolder + "Military_Crate.Military_Crate'");
		ContainerData.CreateContainerData(10, lunchBox, containerMeshFolder + "Lunchbox.Lunchbox'");
		ContainerData.CreateContainerData(15, secretCrate, containerMeshFolder + "Secret_Crate.Secret_Crate'");

		new ContainerItem(medicalCase, "Bandage");
		new ContainerItem(medicalCase, "First Aid Kit");
		new ContainerItem(medicalCase, "Pistol");
		new ContainerItem(medicalCase, "Soda");
		new ContainerItem(medicalCase, "Sandwich");
		new ContainerItem(medicalCase, "5.39");

		new ContainerItem(medicalSupplies, "Bandage");
		new ContainerItem(medicalSupplies, "First Aid Kit");
		new ContainerItem(medicalSupplies, "Pistol");
		new ContainerItem(medicalSupplies, "Soda");
		new ContainerItem(medicalSupplies, "Sandwich");
		new ContainerItem(medicalSupplies, "5.39");

		new ContainerItem(SuppliesCrate, "Wood");
		new ContainerItem(SuppliesCrate, "Nails");
		new ContainerItem(SuppliesCrate, "Cloth");
		new ContainerItem(SuppliesCrate, "Barricade");
		new ContainerItem(SuppliesCrate, "Metal");
		new ContainerItem(SuppliesCrate, "Gunpowder");

		new ContainerItem(lunchBox, "Soda");
		new ContainerItem(lunchBox, "Sandwich");
		new ContainerItem(lunchBox, "Bread");
		new ContainerItem(lunchBox, "Raw Meat");
		new ContainerItem(lunchBox, "Raw Veg");

		new ContainerItem(militaryCrate, "Pistol");
		new ContainerItem(militaryCrate, "Sniper");
		new ContainerItem(militaryCrate, "MP5");
		new ContainerItem(militaryCrate, "SMG");

		new ContainerItem(militaryCrate, "5.39");
		new ContainerItem(militaryCrate, "7.62");

		new ContainerItem(militaryCrate, "Military Chestpiece");
		new ContainerItem(militaryCrate, "Military Vest");
		new ContainerItem(militaryCrate, "Military Legs");
		new ContainerItem(militaryCrate, "Military Headpiece");

		new ContainerItem(secretCrate, "Bandage");
		new ContainerItem(secretCrate, "First Aid Kit");
		new ContainerItem(secretCrate, "Pistol");
		new ContainerItem(secretCrate, "Soda");
		new ContainerItem(secretCrate, "Sandwich");
		new ContainerItem(secretCrate, "MP5");
		new ContainerItem(secretCrate, "Pistol");
		new ContainerItem(secretCrate, "Military Vest");
		new ContainerItem(secretCrate, "Military Legs");
	}

	// Missions
	static {
		// Missions
		Mission.CreateMission(new MissionData(MissionType.Medical));
		Mission.CreateMission(new MissionData(MissionType.Civilian));
		Mission.CreateMission(new MissionData(MissionType.Military));
		Mission.CreateMission(new MissionData(MissionType.Secret));

		MissionType type = MissionType.Medical;

		new MissionContainer(type, medicalSupplies);
		new MissionContainer(type, medicalCase);
		new MissionContainer(type, lunchBox);

		// Mission Loadouts
		MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Doctor"));
		MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Doctor"));
		MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Medical Staff"));
		MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Medical Guards"));
		MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Medical Guards B"));
		MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Sniper Guard"));

		type = MissionType.Civilian;
		new MissionContainer(type, SuppliesCrate);
		new MissionContainer(type, lunchBox);

		MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Civillian"));
		MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Civillian Guard A"));
		MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Civillian Guard B"));

		type = MissionType.Military;
		new MissionContainer(type, medicalSupplies);
		new MissionContainer(type, militaryCrate);

		MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Military Sniper"));
		MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Military Support"));
		MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Military Support"));
		MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Military Support"));

		type = MissionType.Secret;
		new MissionContainer(type, secretCrate);
		new MissionContainer(type, lunchBox);

		MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Doctor"));
		MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Medical Staff"));
		MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Medical Staff"));
		MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Medical Staff"));
		MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Military Sniper"));
		MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Military Sniper"));
		MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Military Support"));
		MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Military Support"));
	}

	static String CraftingDeviceInventory = "Inventory";
	static String CraftingDeviceCookingPot = "Cooking Pot";
	static String CraftingDeviceFurnace = "Furnace";
	static String CraftingDeviceWorkBench = "Workbench";

	// Crafting
	static {
		Recipe.CreateRecipe("Barricade", RecipeType.Manual, 10, InputOutputData.CreateInputOutputData("Wood", 1, InputOutputType.Item, InputOrOutput.Input),
				InputOutputData.CreateInputOutputData("Nails", 1, InputOutputType.Item, InputOrOutput.Input),
				InputOutputData.CreateInputOutputData("Metal", 1, InputOutputType.Item, InputOrOutput.Input),
				InputOutputData.CreateInputOutputData("Barricade", 1, InputOutputType.Item, InputOrOutput.Output));

		Recipe.CreateRecipe("Sniper", RecipeType.Automatic, 5, InputOutputData.CreateInputOutputData("Metal", 1, InputOutputType.Item, InputOrOutput.Input),
				InputOutputData.CreateInputOutputData("Sniper", 1, InputOutputType.Item, InputOrOutput.Output));

		Recipe.CreateRecipe("SMG", RecipeType.Automatic, 5, InputOutputData.CreateInputOutputData("Wood", 1, InputOutputType.Item, InputOrOutput.Input),
				InputOutputData.CreateInputOutputData("SMG", 1, InputOutputType.Item, InputOrOutput.Output));

		Recipe.CreateRecipe("Bandage", RecipeType.Manual, 10, InputOutputData.CreateInputOutputData("Cloth", 1, InputOutputType.Item, InputOrOutput.Input),
				InputOutputData.CreateInputOutputData("Bandage", 1, InputOutputType.Item, InputOrOutput.Output));

		Recipe.CreateRecipe("Iron Ingot", RecipeType.Automatic, 5, InputOutputData.CreateInputOutputData("Metal", 2, InputOutputType.Item, InputOrOutput.Input),
				InputOutputData.CreateInputOutputData("Energy", 5, InputOutputType.Power, InputOrOutput.Input),
				InputOutputData.CreateInputOutputData("Iron Ingot", 1, InputOutputType.Item, InputOrOutput.Output));

		String deviceName = CraftingDeviceInventory;

		CraftingDevice.CreateCraftingDevice(deviceName);

		CraftingDeviceRecipe.CreateCraftingDeviceRecipe(deviceName, "Barricade");
		CraftingDeviceRecipe.CreateCraftingDeviceRecipe(deviceName, "Sniper");
		CraftingDeviceRecipe.CreateCraftingDeviceRecipe(deviceName, "Bandage");

		deviceName = CraftingDeviceCookingPot;

		CraftingDevice.CreateCraftingDevice(CraftingDeviceCookingPot);

		deviceName = CraftingDeviceFurnace;
		CraftingDevice.CreateCraftingDevice(deviceName);
		CraftingDeviceRecipe.CreateCraftingDeviceRecipe(deviceName, "Iron Ingot");

		deviceName = CraftingDeviceWorkBench;
		CraftingDevice.CreateCraftingDevice(deviceName);

		CraftingDeviceRecipe.CreateCraftingDeviceRecipe(deviceName, "Barricade");
		CraftingDeviceRecipe.CreateCraftingDeviceRecipe(deviceName, "Sniper");
		CraftingDeviceRecipe.CreateCraftingDeviceRecipe(deviceName, "Bandage");
	}

	static void AddTableDefinition(Class<?> clazz) {
		TableDefinition td;
		try {
			td = (TableDefinition) clazz.getDeclaredField("Table_Definition").get(null);
			AddTableDefinition(clazz, td);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
	}

	static void AddTableDefinition(Class<?> clazz, TableDefinition td) {
		tableDefinitions.put(clazz, td);
	}

	// Table Definitions
	static {
		AddTableDefinition(Item.class);
		AddTableDefinition(InputOutputData.class);
		AddTableDefinition(CraftingDeviceRecipe.class);
		AddTableDefinition(CraftingDevice.class);
		AddTableDefinition(InstanceCraftingDevice.class);
		AddTableDefinition(InProgressCrafting.class);
	}

	public static void SaveData(ArrayList<String[]> data, String filePath) {
		try {
			File csvOutputFile = new File(filePath);
			FileWriter outputfile = new FileWriter(csvOutputFile);
			CSVWriter writer = new CSVWriter(outputfile);
			writer.writeAll(data);
			writer.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SaveRowData(Item.items);
		SaveRowData(Weapon.weapons);
		SaveRowData(RangedWeapon.rangedWeapons);
		SaveRowData(MeleeWeapon.meleeWeapons);
		SaveRowData(ProjectileWeapon.ProjectileWeapons);
		SaveRowData(Armour.armour);
		SaveRowData(Loadout.loadouts);
		SaveRowData(ContainerData.ContainerData);
		SaveRowData(Consumable.Consumables);
		SaveRowData(Mission.Missions);
		SaveRowData(MissionLoadout.MissionLoadouts);
		SaveRowData(MissionItems.MissionItems);
		SaveRowData(MissionContainer.MissionContainers);
		SaveRowData(ContainerItem.ContainerItems);
		SaveRowData(Recipe.recipes);
		SaveRowData(InputOutputData.inputOutputs);
		SaveRowData(RecipeInputOutputData.RecipeInputOutputData);
		SaveRowData(CraftingDevice.craftingDevices);
		SaveRowData(CraftingDeviceRecipe.craftingDeviceRecipes);
		SaveRowData(InstanceCraftingDevice.instanceCraftingDevices);
		SaveRowData(InProgressCrafting.inProgressCraftingData);
	}

	static <T extends RowData> void SaveRowData(ArrayList<T> data) {
		if (!data.isEmpty()) {
			ArrayList<String[]> dataStrings = new ArrayList<String[]>();

			T firstItem = data.get(0);
			String tableName = firstItem.tableName;

			if (tableDefinitions.containsKey(firstItem.getClass())) {
				System.out.println(tableDefinitions.get(firstItem.getClass()).toString());
			} else {
				System.out.println("Table" + tableName + " is missing table def");
			}

			for (T d : data) {
				dataStrings.add(CreateData(d));
			}
			SaveData(dataStrings, tablesFolder + tableName);
		} else {
			System.out.println("Table is empty");
		}
	}

	private static String[] CreateData(RowData row) {
		return row.CreateData();
	}
}
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
		Item.CreateItem(new ItemData("Raw Copper", iconFolder + "Iron.Iron'", "", 100));
		Item.CreateItem(new ItemData("Copper Ingot", iconFolder + "Iron.Iron'", "", 100));

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

		ContainerItem.CreateContainerItem(medicalCase, "Bandage");
		ContainerItem.CreateContainerItem(medicalCase, "First Aid Kit");
		ContainerItem.CreateContainerItem(medicalCase, "Pistol");
		ContainerItem.CreateContainerItem(medicalCase, "Soda");
		ContainerItem.CreateContainerItem(medicalCase, "Sandwich");
		ContainerItem.CreateContainerItem(medicalCase, "5.39");

		ContainerItem.CreateContainerItem(medicalSupplies, "Bandage");
		ContainerItem.CreateContainerItem(medicalSupplies, "First Aid Kit");
		ContainerItem.CreateContainerItem(medicalSupplies, "Pistol");
		ContainerItem.CreateContainerItem(medicalSupplies, "Soda");
		ContainerItem.CreateContainerItem(medicalSupplies, "Sandwich");
		ContainerItem.CreateContainerItem(medicalSupplies, "5.39");

		ContainerItem.CreateContainerItem(SuppliesCrate, "Wood");
		ContainerItem.CreateContainerItem(SuppliesCrate, "Nails");
		ContainerItem.CreateContainerItem(SuppliesCrate, "Cloth");
		ContainerItem.CreateContainerItem(SuppliesCrate, "Barricade");
		ContainerItem.CreateContainerItem(SuppliesCrate, "Metal");
		ContainerItem.CreateContainerItem(SuppliesCrate, "Gunpowder");
		ContainerItem.CreateContainerItem(SuppliesCrate, "Raw Copper");

		ContainerItem.CreateContainerItem(lunchBox, "Soda");
		ContainerItem.CreateContainerItem(lunchBox, "Sandwich");
		ContainerItem.CreateContainerItem(lunchBox, "Bread");
		ContainerItem.CreateContainerItem(lunchBox, "Raw Meat");
		ContainerItem.CreateContainerItem(lunchBox, "Raw Veg");

		ContainerItem.CreateContainerItem(militaryCrate, "Pistol");
		ContainerItem.CreateContainerItem(militaryCrate, "Sniper");
		ContainerItem.CreateContainerItem(militaryCrate, "MP5");
		ContainerItem.CreateContainerItem(militaryCrate, "SMG");

		ContainerItem.CreateContainerItem(militaryCrate, "5.39");
		ContainerItem.CreateContainerItem(militaryCrate, "7.62");

		ContainerItem.CreateContainerItem(militaryCrate, "Military Chestpiece");
		ContainerItem.CreateContainerItem(militaryCrate, "Military Vest");
		ContainerItem.CreateContainerItem(militaryCrate, "Military Legs");
		ContainerItem.CreateContainerItem(militaryCrate, "Military Headpiece");

		ContainerItem.CreateContainerItem(secretCrate, "Bandage");
		ContainerItem.CreateContainerItem(secretCrate, "First Aid Kit");
		ContainerItem.CreateContainerItem(secretCrate, "Pistol");
		ContainerItem.CreateContainerItem(secretCrate, "Soda");
		ContainerItem.CreateContainerItem(secretCrate, "Sandwich");
		ContainerItem.CreateContainerItem(secretCrate, "MP5");
		ContainerItem.CreateContainerItem(secretCrate, "Pistol");
		ContainerItem.CreateContainerItem(secretCrate, "Military Vest");
		ContainerItem.CreateContainerItem(secretCrate, "Military Legs");
	}

	// Missions
	static {
		// Missions
		Mission.CreateMission(new MissionData(MissionType.Medical));
		Mission.CreateMission(new MissionData(MissionType.Civilian));
		Mission.CreateMission(new MissionData(MissionType.Military));
		Mission.CreateMission(new MissionData(MissionType.Secret));

		MissionType type = MissionType.Medical;

		MissionContainer.CreateMissionContainer(type, medicalSupplies);
		MissionContainer.CreateMissionContainer(type, medicalCase);
		MissionContainer.CreateMissionContainer(type, lunchBox);

		// Mission Loadouts
		MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Doctor"));
		MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Doctor"));
		MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Medical Staff"));
		MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Medical Guards"));
		MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Medical Guards B"));
		MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Sniper Guard"));

		type = MissionType.Civilian;
		MissionContainer.CreateMissionContainer(type, SuppliesCrate);
		MissionContainer.CreateMissionContainer(type, lunchBox);

		MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Civillian"));
		MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Civillian Guard A"));
		MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Civillian Guard B"));

		type = MissionType.Military;
		MissionContainer.CreateMissionContainer(type, medicalSupplies);
		MissionContainer.CreateMissionContainer(type, militaryCrate);

		MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Military Sniper"));
		MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Military Support"));
		MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Military Support"));
		MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Military Support"));

		type = MissionType.Secret;
		MissionContainer.CreateMissionContainer(type, secretCrate);
		MissionContainer.CreateMissionContainer(type, lunchBox);

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

		Recipe.CreateRecipe("Copper Ingot", RecipeType.Manual, 5, InputOutputData.CreateInputOutputData("Raw Copper", 2, InputOutputType.Item, InputOrOutput.Input),
				InputOutputData.CreateInputOutputData("Copper Ingot", 1, InputOutputType.Item, InputOrOutput.Output));

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
		AddTableDefinition(Armour.class);
		AddTableDefinition(Consumable.class);
		AddTableDefinition(ContainerData.class);
		AddTableDefinition(ContainerItem.class);
		AddTableDefinition(Recipe.class);
		AddTableDefinition(RecipeInputOutputData.class);
		AddTableDefinition(InputOutputData.class);
		AddTableDefinition(CraftingDeviceRecipe.class);
		AddTableDefinition(CraftingDevice.class);
		AddTableDefinition(InstanceCraftingDevice.class);
		AddTableDefinition(InProgressCrafting.class);
		AddTableDefinition(Weapon.class);
		AddTableDefinition(RangedWeapon.class);
		AddTableDefinition(MeleeWeapon.class);
		AddTableDefinition(ProjectileWeapon.class);
		AddTableDefinition(Loadout.class);
		AddTableDefinition(Mission.class);
		AddTableDefinition(MissionLoadout.class);
		AddTableDefinition(MissionContainer.class);
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
		SaveRowData(Item.class, Item.items);
		SaveRowData(Weapon.class, Weapon.weapons);
		SaveRowData(RangedWeapon.class, RangedWeapon.rangedWeapons);
		SaveRowData(MeleeWeapon.class, MeleeWeapon.meleeWeapons);
		SaveRowData(ProjectileWeapon.class, ProjectileWeapon.ProjectileWeapons);
		SaveRowData(Armour.class, Armour.armour);
		SaveRowData(Loadout.class, Loadout.loadouts);
		SaveRowData(ContainerData.class, ContainerData.ContainerData);
		SaveRowData(Consumable.class, Consumable.Consumables);
		SaveRowData(Mission.class, Mission.Missions);
		SaveRowData(MissionLoadout.class, MissionLoadout.MissionLoadouts);
		SaveRowData(MissionItems.class, MissionItems.MissionItems);
		SaveRowData(MissionContainer.class, MissionContainer.MissionContainers);
		SaveRowData(ContainerItem.class, ContainerItem.ContainerItems);
		SaveRowData(Recipe.class, Recipe.recipes);
		SaveRowData(InputOutputData.class, InputOutputData.inputOutputs);
		SaveRowData(RecipeInputOutputData.class, RecipeInputOutputData.RecipeInputOutputData);
		SaveRowData(CraftingDevice.class, CraftingDevice.craftingDevices);
		SaveRowData(CraftingDeviceRecipe.class, CraftingDeviceRecipe.craftingDeviceRecipes);
		SaveRowData(InstanceCraftingDevice.class, InstanceCraftingDevice.instanceCraftingDevices);
		SaveRowData(InProgressCrafting.class, InProgressCrafting.inProgressCraftingData);
	}

	static <T extends RowData> void SaveRowData(Class<?> clazz, ArrayList<T> data) {
		if (!data.isEmpty()) {
			ArrayList<String[]> dataStrings = new ArrayList<String[]>();

			T firstItem = data.get(0);
			String tableName = firstItem.tableName;

			if (tableDefinitions.containsKey(clazz)) {
				System.out.println(tableDefinitions.get(clazz).toString());
			} else {
				System.out.println("Table" + tableName + " is missing table def");
			}

			for (T d : data) {
				dataStrings.add(CreateData(d));
			}
			SaveData(dataStrings, tablesFolder + tableName);
		} else {
// TODO make it possible to get the table path statically
//			File csvOutputFile = new File(clazz.getDeclaredField("").get(null));
//			if (!csvOutputFile.exists()) {
//				FileWriter outputfile = new FileWriter(csvOutputFile);
//				CSVWriter writer = new CSVWriter(outputfile);
//				writer.writeAll(data);
//				writer.close();
//			}

			System.out.println("Table " + clazz.getSimpleName() + " is empty");
		}
	}

	private static String[] CreateData(RowData row) {
		return row.CreateData();
	}
}
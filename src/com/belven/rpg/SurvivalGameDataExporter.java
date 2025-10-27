package com.belven.rpg;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import com.belven.rpg.items.Armour;
import com.belven.rpg.items.ArmourPosition;
import com.belven.rpg.items.CharacterType;
import com.belven.rpg.items.Consumable;
import com.belven.rpg.items.ConsumableData;
import com.belven.rpg.items.ConsumableType;
import com.belven.rpg.items.ContainerData;
import com.belven.rpg.items.ContainerItem;
import com.belven.rpg.items.GearType;
import com.belven.rpg.items.Item;
import com.belven.rpg.items.ItemData;
import com.belven.rpg.items.ItemType;
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
	static ArrayList<RowData> tablesRows = new ArrayList<>();
	static String tablesFolder = "E:\\Unreal Projects\\SurvivalTest\\Source\\Tables";
	static String iconFolder = "Texture2D'/Game/FirstPerson/Icons/";
	static String weaponsMeshFolder = "StaticMesh'/Game/FirstPerson/Weapons/";
	static String containerMeshFolder = "StaticMesh'/Game/FirstPerson/LootBoxes/";

	static {
		int health = 100;

		// Weapons
		tablesRows.add(ProjectileWeapon.CreateProjectileWeapon(new ItemData("Test Weapon", 1), new WeaponData(15000, 11, 0.01f, false, GearType.Weapon), 0.9995f,
				new ProjectileWeaponData("Test Ammo", 10, 0.2f, 15000)));
		tablesRows.add(Item.CreateItem(new ItemData("Test Ammo", iconFolder + "539.539'", "", 30, ItemType.Ammo)));
		tablesRows.add(Loadout.CreateLoadout(new LoadoutData("Test AI", "Test Weapon", "", "Chestpiece", "", "Legs", health, 800, CharacterType.Enemy)));

		tablesRows.add(MeleeWeapon.CreateMeleeWeapon(new ItemData("Knife", 1), new WeaponData(400, 60, 1, false, GearType.Weapon), 300));
		tablesRows.add(MeleeWeapon.CreateMeleeWeapon(new ItemData("Axe", 1), new WeaponData(100, 100, 2, false, GearType.Weapon), 300));

		tablesRows.add(
				ProjectileWeapon.CreateProjectileWeapon(new ItemData("SMG", 1), new WeaponData(15000, 11, 0.2f, false, GearType.Weapon), 0.9975f, new ProjectileWeaponData("5.39", 60, 2f, 15000)));

		tablesRows.add(
				ProjectileWeapon.CreateProjectileWeapon(new ItemData("MP5", 1), new WeaponData(18000, 22, 0.25f, false, GearType.Weapon), 0.9985f, new ProjectileWeaponData("7.62", 30, 1f, 18000)));

		tablesRows.add(
				ProjectileWeapon.CreateProjectileWeapon(new ItemData("Pistol", 1), new WeaponData(15000, 25, 0.4f, false, GearType.Sidearm), 0.998f, new ProjectileWeaponData("5.39", 8, 0.8f, 13000)));

		tablesRows.add(
				ProjectileWeapon.CreateProjectileWeapon(new ItemData("Sniper", 1), new WeaponData(40000, 100, 1.2f, false, GearType.Weapon), 0.9999f, new ProjectileWeaponData("7.62", 5, 2f, 30000)));

		tablesRows.add(ContainerData.CreateContainerData(0, "Zero Base", ""));
		tablesRows.add(ContainerData.CreateContainerData(5, "Five base", ""));
		tablesRows.add(ContainerData.CreateContainerData(10, "Ten base", ""));
		tablesRows.add(ContainerData.CreateContainerData(15, "Character Inventory", ""));

		// Armour
		tablesRows.add(Armour.CreateArmour(new ItemData("Headpiece", iconFolder + "helmet.helmet'", "", 1), ArmourPosition.Head, 0));
		tablesRows.add(Armour.CreateArmour(new ItemData("Chestpiece", iconFolder + "armor.armor'", "", 1), ArmourPosition.Chest, 2));
		tablesRows.add(Armour.CreateArmour(new ItemData("Legs", iconFolder + "legs.legs'", "", 1), ArmourPosition.Legs, 1));
		tablesRows.add(Armour.CreateArmour(new ItemData("Vest", iconFolder + "vest.vest'", "", 1), ArmourPosition.Vest, 1));

		// Military Armour
		tablesRows.add(Armour.CreateArmour(new ItemData("Military Headpiece", iconFolder + "helmet.helmet'", "", 1), ArmourPosition.Head, 0, 10));
		tablesRows.add(Armour.CreateArmour(new ItemData("Military Chestpiece", iconFolder + "armor.armor'", "", 1), ArmourPosition.Chest, 2, 10));
		tablesRows.add(Armour.CreateArmour(new ItemData("Military Legs", iconFolder + "legs.legs'", "", 1), ArmourPosition.Legs, 1, 10));
		tablesRows.add(Armour.CreateArmour(new ItemData("Military Vest", iconFolder + "vest.vest'", "", 1), ArmourPosition.Vest, 1, 10));

		// Resources
		tablesRows.add(Item.CreateItem(new ItemData("Wood", iconFolder + "wood.wood'", "", 20)));
		tablesRows.add(Item.CreateItem(new ItemData("Nails", iconFolder + "nails.nails'", "", 20)));

		// Ammo
		tablesRows.add(Item.CreateItem(new ItemData("7.62", iconFolder + "762.762'", "", 100, ItemType.Ammo)));
		tablesRows.add(Item.CreateItem(new ItemData("5.39", iconFolder + "539.539'", "", 100, ItemType.Ammo)));

		// Consumables
		tablesRows.add(Consumable.CreateConsumable(new ItemData("Bandage", iconFolder + "bandage.bandage'", "", 5), new ConsumableData(ConsumableType.Medical, 20)));
		tablesRows.add(Consumable.CreateConsumable(new ItemData("First Aid Kit", iconFolder + "FirstAidKit.FirstAidKit'", "", 5), new ConsumableData(ConsumableType.Medical, 50)));
		tablesRows.add(Consumable.CreateConsumable(new ItemData("Soda", iconFolder + "soda.soda'", "", 100), new ConsumableData(ConsumableType.Drink, 20)));
		tablesRows.add(Consumable.CreateConsumable(new ItemData("Sandwich", iconFolder + "sandwich.sandwich'", "", 5), new ConsumableData(ConsumableType.Food, 20)));

		// Loadouts
		tablesRows.add(Loadout.CreateLoadout(new LoadoutData("Player", "MP5", "", "Chestpiece", "", "Legs", health * 100, 800, CharacterType.Player)));
		tablesRows.add(Loadout.CreateLoadout(new LoadoutData("AI Base", "SMG", "Headpiece", "Chestpiece", "", "Legs", health, 800, CharacterType.Enemy)));

		// Medical Loadouts
		tablesRows.add(Loadout.CreateLoadout(new LoadoutData("Medical Staff", "Pistol", "", "Chestpiece", "", "Legs", health, 800, CharacterType.Enemy)));
		tablesRows.add(Loadout.CreateLoadout(new LoadoutData("Medical Guards", "MP5", "", "Military Chestpiece", "Military Vest", "Military Legs", health, 800, CharacterType.Enemy)));
		tablesRows.add(Loadout.CreateLoadout(new LoadoutData("Medical Guards B", "SMG", "", "Chestpiece", "Vest", "Military Legs", health, 800, CharacterType.Enemy)));
		tablesRows.add(Loadout.CreateLoadout(new LoadoutData("Sniper Guard", "Sniper", "Military Headpiece", "Chestpiece", "Vest", "Military Legs", health, 800, CharacterType.Enemy)));
		tablesRows.add(Loadout.CreateLoadout(new LoadoutData("Doctor", "Knife", "", "", "", "Legs", health, 800, CharacterType.Enemy)));

		tablesRows.add(Loadout.CreateLoadout(new LoadoutData("Civillian", "Pistol", "", "Chestpiece", "", "Legs", health, 800, CharacterType.Enemy)));
		tablesRows.add(Loadout.CreateLoadout(new LoadoutData("Civillian Guard A", "MP5", "", "Chestpiece", "", "Legs", health, 800, CharacterType.Enemy)));
		tablesRows.add(Loadout.CreateLoadout(new LoadoutData("Civillian Guard B", "SMG", "", "Chestpiece", "Vest", "Military Legs", health, 800, CharacterType.Enemy)));

		tablesRows.add(Loadout.CreateLoadout(new LoadoutData("Military Sniper", "Sniper", "Military Headpiece", "Chestpiece", "", "Legs", health, 800, CharacterType.Enemy)));
		tablesRows.add(
				Loadout.CreateLoadout(new LoadoutData("Military Assault", "MP5", "Military Headpiece", "Military Chestpiece", "Military Vest", "Military Legs", health, 800, CharacterType.Enemy)));
		tablesRows.add(
				Loadout.CreateLoadout(new LoadoutData("Military Support", "SMG", "Military Headpiece", "Military Chestpiece", "Military Vest", "Military Legs", health, 800, CharacterType.Enemy)));

		String WoodenCrate = "Wooden Crate";
		String medicalCase = "Medical Case";
		String medicalSupplies = "Medical Supplies";
		String militaryCrate = "Military Crate";
		String secretCrate = "Secret Crate";

		tablesRows.add(ContainerData.CreateContainerData(20, WoodenCrate, containerMeshFolder + "Crate.Crate'"));
		tablesRows.add(ContainerData.CreateContainerData(5, medicalCase, containerMeshFolder + "Medical_Case.Medical_Case'"));
		tablesRows.add(ContainerData.CreateContainerData(15, medicalSupplies, containerMeshFolder + "Medical_Supplies.Medical_Supplies'"));
		tablesRows.add(ContainerData.CreateContainerData(15, militaryCrate, containerMeshFolder + "Military_Crate.Military_Crate'"));

		// TODO make new model or secret crate
		tablesRows.add(ContainerData.CreateContainerData(15, secretCrate, containerMeshFolder + "Military_Crate.Military_Crate'"));

		tablesRows.add(new ContainerItem(medicalCase, "Bandage"));
		tablesRows.add(new ContainerItem(medicalCase, "First Aid Kit"));
		tablesRows.add(new ContainerItem(medicalCase, "Pistol"));
		tablesRows.add(new ContainerItem(medicalCase, "Soda"));
		tablesRows.add(new ContainerItem(medicalCase, "Sandwich"));
		tablesRows.add(new ContainerItem(medicalCase, "5.39"));

		tablesRows.add(new ContainerItem(medicalSupplies, "Bandage"));
		tablesRows.add(new ContainerItem(medicalSupplies, "First Aid Kit"));
		tablesRows.add(new ContainerItem(medicalSupplies, "Pistol"));
		tablesRows.add(new ContainerItem(medicalSupplies, "Soda"));
		tablesRows.add(new ContainerItem(medicalSupplies, "Sandwich"));
		tablesRows.add(new ContainerItem(medicalSupplies, "5.39"));

		tablesRows.add(new ContainerItem(WoodenCrate, "Wood"));
		tablesRows.add(new ContainerItem(WoodenCrate, "Nails"));
		tablesRows.add(new ContainerItem(WoodenCrate, "Soda"));
		tablesRows.add(new ContainerItem(WoodenCrate, "Sandwich"));

		tablesRows.add(new ContainerItem(militaryCrate, "Pistol"));
		tablesRows.add(new ContainerItem(militaryCrate, "Sniper"));
		tablesRows.add(new ContainerItem(militaryCrate, "MP5"));
		tablesRows.add(new ContainerItem(militaryCrate, "SMG"));

		tablesRows.add(new ContainerItem(militaryCrate, "5.39"));
		tablesRows.add(new ContainerItem(militaryCrate, "7.62"));

		tablesRows.add(new ContainerItem(militaryCrate, "Military Chestpiece"));
		tablesRows.add(new ContainerItem(militaryCrate, "Military Vest"));
		tablesRows.add(new ContainerItem(militaryCrate, "Military Legs"));
		tablesRows.add(new ContainerItem(militaryCrate, "Military Headpiece"));

		tablesRows.add(new ContainerItem(secretCrate, "Bandage"));
		tablesRows.add(new ContainerItem(secretCrate, "First Aid Kit"));
		tablesRows.add(new ContainerItem(secretCrate, "Pistol"));
		tablesRows.add(new ContainerItem(secretCrate, "Soda"));
		tablesRows.add(new ContainerItem(secretCrate, "Sandwich"));
		tablesRows.add(new ContainerItem(secretCrate, "MP5"));
		tablesRows.add(new ContainerItem(secretCrate, "Pistol"));
		tablesRows.add(new ContainerItem(secretCrate, "Military Vest"));
		tablesRows.add(new ContainerItem(secretCrate, "Military Legs"));

		// Missions
		tablesRows.add(Mission.CreateMission(new MissionData(MissionType.Medical)));
		tablesRows.add(Mission.CreateMission(new MissionData(MissionType.Civilian)));
		tablesRows.add(Mission.CreateMission(new MissionData(MissionType.Military)));
		tablesRows.add(Mission.CreateMission(new MissionData(MissionType.Secret)));

		tablesRows.add(new MissionContainer(MissionType.Medical, medicalSupplies));
		tablesRows.add(new MissionContainer(MissionType.Medical, medicalCase));

		tablesRows.add(new MissionContainer(MissionType.Civilian, WoodenCrate));

		tablesRows.add(new MissionContainer(MissionType.Military, medicalSupplies));
		tablesRows.add(new MissionContainer(MissionType.Military, militaryCrate));

		tablesRows.add(new MissionContainer(MissionType.Secret, medicalSupplies));
		tablesRows.add(new MissionContainer(MissionType.Secret, militaryCrate));

		MissionType type = MissionType.Medical;

		// Mission Loadouts
//		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(MissionType.Medical, "Test AI")));
//		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(MissionType.Medical, "Test AI")));
//		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(MissionType.Medical, "Test AI")));
//		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(MissionType.Medical, "Test AI")));

		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Doctor")));
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Doctor")));
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Medical Staff")));
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Medical Guards")));
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Medical Guards B")));
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Sniper Guard")));

//		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(MissionType.Civilian, "Test AI")));
//		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(MissionType.Civilian, "Test AI")));
//		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(MissionType.Civilian, "Test AI")));
//		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(MissionType.Civilian, "Test AI")));

		type = MissionType.Civilian;
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Civillian")));
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Civillian Guard A")));
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Civillian Guard B")));

		type = MissionType.Military;
//		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(MissionType.Military, "Test AI")));
//		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(MissionType.Military, "Test AI")));
//		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(MissionType.Military, "Test AI")));
//		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(MissionType.Military, "Test AI")));
//		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(MissionType.Military, "Test AI")));
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Military Sniper")));
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Military Support")));
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Military Support")));
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Military Support")));

		type = MissionType.Secret;
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Doctor")));
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Medical Staff")));
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Medical Staff")));
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Medical Staff")));
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Military Sniper")));
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Military Sniper")));
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Military Support")));
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(type, "Military Support")));
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
	}

	static <T extends RowData> void SaveRowData(ArrayList<T> data) {

		if (!data.isEmpty()) {
			ArrayList<String[]> dataStrings = new ArrayList<String[]>();

			for (T d : data) {
				dataStrings.add(CreateData(d));
			}
			SaveData(dataStrings, tablesFolder + data.get(0).tableName);
		} else {
			System.out.println("Table is empty");
		}
	}

	private static String[] CreateData(RowData row) {
		return row.CreateData();
	}
}
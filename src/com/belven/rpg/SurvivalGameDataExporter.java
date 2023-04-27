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
import com.belven.rpg.items.GearType;
import com.belven.rpg.items.Item;
import com.belven.rpg.items.ItemData;
import com.belven.rpg.items.RowData;
import com.belven.rpg.mission.Loadout;
import com.belven.rpg.mission.LoadoutData;
import com.belven.rpg.mission.Mission;
import com.belven.rpg.mission.MissionData;
import com.belven.rpg.mission.MissionItemData;
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
	static String tablesFolder = "D:\\Unreal Projects\\SurvivalTest\\Source\\Tables";
	static String iconFolder = "Texture2D'/Game/FirstPerson/Icons/";
	static String weaponsMeshFolder = "StaticMesh'/Game/FirstPerson/Weapons/";
	static String containerMeshFolder = "StaticMesh'/Game/FirstPerson/LootBoxes/";

	static {
		int health = 100;

		// Weapons
		tablesRows.add(MeleeWeapon.CreateMeleeWeapon(new ItemData("Knife", 2), new WeaponData(400, 60, 1, false, GearType.Secondary_Weapon), 300));
		tablesRows.add(MeleeWeapon.CreateMeleeWeapon(new ItemData("Axe", 1), new WeaponData(100, 100, 2, false, GearType.Secondary_Weapon), 300));

		tablesRows.add(ProjectileWeapon.CreateProjectileWeapon(new ItemData("SMG", 1), new WeaponData(15000, 11, 0.2f, false, GearType.Primary_Weapon), 1,
				new ProjectileWeaponData("Projectile", 60, 2f, 15000)));

		tablesRows.add(ProjectileWeapon.CreateProjectileWeapon(new ItemData("AK", 1), new WeaponData(18000, 22, 0.25f, false, GearType.Primary_Weapon), 1,
				new ProjectileWeaponData("Projectile", 30, 1f, 18000)));

		tablesRows.add(
				ProjectileWeapon.CreateProjectileWeapon(new ItemData("Pistol", 1), new WeaponData(15000, 25, 0.4f, false, GearType.Sidearm), 1, new ProjectileWeaponData("Projectile", 8, 0.8f, 13000)));
		tablesRows.add(ProjectileWeapon.CreateProjectileWeapon(new ItemData("Sniper", 1), new WeaponData(40000, 100, 1.2f, false, GearType.Primary_Weapon), 1,
				new ProjectileWeaponData("Projectile", 5, 2f, 30000)));

		tablesRows.add(ContainerData.CreateContainerData(0, "Zero Base", "", MissionType.End));
		tablesRows.add(ContainerData.CreateContainerData(5, "Five base", "", MissionType.End));
		tablesRows.add(ContainerData.CreateContainerData(10, "Ten base", "", MissionType.End));
		tablesRows.add(ContainerData.CreateContainerData(8, "Character Inventory", "", MissionType.End));
		tablesRows.add(ContainerData.CreateContainerData(5, "Medical Case", containerMeshFolder + "Medical_Case.Medical_Case'", MissionType.Medical));
		tablesRows.add(ContainerData.CreateContainerData(10, "Medical Supplies", containerMeshFolder + "Medical_Supplies.Medical_Supplies'", MissionType.Medical));

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

		// Consumables
		tablesRows.add(Consumable.CreateConsumable(new ItemData("Bandage", iconFolder + "bandage.bandage'", "", 5), new ConsumableData(ConsumableType.Medical, 20)));
		tablesRows.add(Consumable.CreateConsumable(new ItemData("Soda", iconFolder + "soda.soda'", "", 5), new ConsumableData(ConsumableType.Drink, 20)));
		tablesRows.add(Consumable.CreateConsumable(new ItemData("Sandwich", iconFolder + "sandwich.sandwich'", "", 5), new ConsumableData(ConsumableType.Food, 20)));

		// Loadouts
		tablesRows.add(Loadout.CreateLoadout(new LoadoutData("Player", "AK", "", "Chestpiece", "", "Legs", health * 10, 800, CharacterType.Player)));
		tablesRows.add(Loadout.CreateLoadout(new LoadoutData("AI Base", "SMG", "Headpiece", "Chestpiece", "", "Legs", health, 800, CharacterType.Enemy)));

		// Medical Loadouts
		tablesRows.add(Loadout.CreateLoadout(new LoadoutData("Medical Staff", "Pistol", "", "Chestpiece", "", "Legs", health, 800, CharacterType.Enemy)));
		tablesRows.add(Loadout.CreateLoadout(new LoadoutData("Medical Guards", "AK", "", "Military Chestpiece", "Military Vest", "Military Legs", health, 800, CharacterType.Enemy)));
		tablesRows.add(Loadout.CreateLoadout(new LoadoutData("Medical Guards B", "SMG", "", "Chestpiece", "Vest", "Military Legs", health, 800, CharacterType.Enemy)));
		tablesRows.add(Loadout.CreateLoadout(new LoadoutData("Sniper Guard", "Sniper", "Military Headpiece", "Chestpiece", "Vest", "Military Legs", health, 800, CharacterType.Enemy)));
		tablesRows.add(Loadout.CreateLoadout(new LoadoutData("Doctor", "Knife", "", "", "", "Legs", health, 800, CharacterType.Enemy)));

		// Missions
		tablesRows.add(Mission.CreateMission(new MissionData(MissionType.Medical)));

		// Mission Loadouts
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(MissionType.Medical, "Doctor")));
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(MissionType.Medical, "Doctor")));
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(MissionType.Medical, "Medical Staff")));
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(MissionType.Medical, "Medical Guards")));
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(MissionType.Medical, "Medical Guards")));
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(MissionType.Medical, "Medical Guards B")));
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(MissionType.Medical, "Medical Guards B")));
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(MissionType.Medical, "Sniper Guard")));
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(MissionType.Medical, "Sniper Guard")));
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(MissionType.Medical, "Doctor")));
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(MissionType.Medical, "Doctor")));
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(MissionType.Medical, "Medical Staff")));
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(MissionType.Medical, "Medical Guards")));
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(MissionType.Medical, "Medical Guards")));
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(MissionType.Medical, "Medical Guards B")));
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(MissionType.Medical, "Medical Guards B")));
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(MissionType.Medical, "Sniper Guard")));
		tablesRows.add(MissionLoadout.CreateMissonLoadout(new MissionLoadoutData(MissionType.Medical, "Sniper Guard")));

		// Mission Items
		tablesRows.add(MissionItems.CreateMissonItem(new MissionItemData(MissionType.Medical, "Bandage")));
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
	}

	static <T extends RowData> void SaveRowData(ArrayList<T> data) {
		ArrayList<String[]> dataStrings = new ArrayList<String[]>();

		for (T d : data) {
			dataStrings.add(CreateData(d));
		}
		SaveData(dataStrings, tablesFolder + data.get(0).tableName);
	}

	private static String[] CreateData(RowData row) {
		return row.CreateData();
	}
}
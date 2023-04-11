package com.belven.rpg;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import com.belven.rpg.items.Armour;
import com.belven.rpg.items.ArmourPosition;
import com.belven.rpg.items.CharacterType;
import com.belven.rpg.items.ContainerData;
import com.belven.rpg.items.GearType;
import com.belven.rpg.items.Item;
import com.belven.rpg.items.ItemData;
import com.belven.rpg.items.Loadout;
import com.belven.rpg.items.LoadoutData;
import com.belven.rpg.items.MeleeWeapon;
import com.belven.rpg.items.ProjectileWeapon;
import com.belven.rpg.items.ProjectileWeaponData;
import com.belven.rpg.items.RangedWeapon;
import com.belven.rpg.items.RowData;
import com.belven.rpg.items.Weapon;
import com.belven.rpg.items.WeaponData;
import com.opencsv.CSVWriter;

public class SurvivalGameDataExporter {
	static ArrayList<RowData> tablesRows = new ArrayList<>();
	static String tablesFolder = "D:\\Unreal Projects\\SurvivalTest\\Source\\Tables";
	static String iconFolder = "Texture2D'/Game/FirstPerson/Icons/";

	static {
		int health = 100;

		// Weapons
		tablesRows.add(MeleeWeapon.CreateMeleeWeapon(new ItemData("Knife", iconFolder + "knife.knife'", 2), new WeaponData(500, 50, 1, false, GearType.Secondary_Weapon), 300));
		tablesRows.add(MeleeWeapon.CreateMeleeWeapon(new ItemData("Axe", iconFolder + "axe.axe'", 1), new WeaponData(500, 100, 2, false, GearType.Secondary_Weapon), 300));

		float smgFireRate = (1.0f / 5.0f);

		tablesRows.add(ProjectileWeapon.CreateProjectileWeapon(new ItemData("SMG", iconFolder + "smg.smg'", 1), new WeaponData(1500, health / (3 / smgFireRate), smgFireRate, false, GearType.Primary_Weapon), 1,
				new ProjectileWeaponData("Projectile", 50, 1.2f)));

		float akFireRate = (1.0f / 4.0f);

		tablesRows.add(ProjectileWeapon.CreateProjectileWeapon(new ItemData("AK", iconFolder + "ak.ak'", 1), new WeaponData(1500, health / (3 / akFireRate), akFireRate, false, GearType.Primary_Weapon), 1,
				new ProjectileWeaponData("Projectile", 50, 1.2f)));

		tablesRows.add(ContainerData.CreateContainerData(0, "Zero Base"));
		tablesRows.add(ContainerData.CreateContainerData(5, "Five base"));
		tablesRows.add(ContainerData.CreateContainerData(10, "Ten base"));
		tablesRows.add(ContainerData.CreateContainerData(8, "Character Inventory"));

		// Armour
		tablesRows.add(Armour.CreateArmour(new ItemData("Headpiece", iconFolder + "helmet.helmet'", 1), ArmourPosition.Head, 0));
		tablesRows.add(Armour.CreateArmour(new ItemData("Chestpiece", iconFolder + "armor.armor'", 1), ArmourPosition.Chest, 2));
		tablesRows.add(Armour.CreateArmour(new ItemData("Legs", iconFolder + "legs.legs'", 1), ArmourPosition.Legs, 1));
		tablesRows.add(Armour.CreateArmour(new ItemData("Vest", iconFolder + "vest.vest'", 1), ArmourPosition.Vest, 1));

		tablesRows.add(Loadout.CreateLoadout(new LoadoutData(1, 2, 3, 4, 5, health, 800, CharacterType.Enemy)));
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
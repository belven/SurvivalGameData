package com.belven.rpg;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import com.belven.rpg.items.Armour;
import com.belven.rpg.items.ArmourPosition;
import com.belven.rpg.items.CharacterType;
import com.belven.rpg.items.ContainerData;
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

	static {
		//Weapons
		tablesRows.add(MeleeWeapon.CreateMeleeWeapon(new ItemData("Test Melee Weapon 1", "Melee 1", 1), new WeaponData(500, 30, 1, false), 300));
		tablesRows.add(MeleeWeapon.CreateMeleeWeapon(new ItemData("Test Melee Weapon 2", "Melee 2", 1), new WeaponData(500, 30, 1, false), 300));
		tablesRows.add(ProjectileWeapon.CreateProjectileWeapon(new ItemData("Test Projectile Weapon 1", "Projectile 1", 1), new WeaponData(500, 30, 0.1f, false), 1, new ProjectileWeaponData("Projectile", 50, 1.2f)));
		
		tablesRows.add(ContainerData.CreateContainerData(0, "Zero Base"));
		tablesRows.add(ContainerData.CreateContainerData(5, "Five base"));
		tablesRows.add(ContainerData.CreateContainerData(10, "Ten base"));
		
		// Armour
		tablesRows.add(Armour.CreateArmour(new ItemData("Headpiece", "Head", 1), ArmourPosition.Head, 1));
		tablesRows.add(Armour.CreateArmour(new ItemData("Chestpiece", "Chest", 2), ArmourPosition.Chest, 3));
		tablesRows.add(Armour.CreateArmour(new ItemData("Legs", "Legs", 1), ArmourPosition.Legs, 2));
		
		tablesRows.add(Loadout.CreateLoadout(new LoadoutData(1, 4, 5, 6, 9, 1000, 800, CharacterType.Enemy)));
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
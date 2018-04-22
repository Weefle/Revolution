package fr.weefle.revolution.npc;

public enum NpcType {
	
	ARMOR("Robert l'armurier"), WEAPONS("Jacques le forgeron"), ENCHANTER("Merlin l'enchanteur");
	
	private String name;
	
	NpcType(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}

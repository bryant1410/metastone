package net.pferdimanzug.hearthstone.analyzer.game.cards.concrete.naxxramas;

import net.pferdimanzug.hearthstone.analyzer.game.cards.MinionCard;
import net.pferdimanzug.hearthstone.analyzer.game.cards.Rarity;
import net.pferdimanzug.hearthstone.analyzer.game.entities.heroes.HeroClass;
import net.pferdimanzug.hearthstone.analyzer.game.entities.minions.Minion;
import net.pferdimanzug.hearthstone.analyzer.game.entities.minions.Race;
import net.pferdimanzug.hearthstone.analyzer.game.spells.Spell;
import net.pferdimanzug.hearthstone.analyzer.game.spells.SummonSpell;
import net.pferdimanzug.hearthstone.analyzer.game.targeting.EntityReference;

public class HauntedCreeper extends MinionCard {

	public HauntedCreeper() {
		super("Haunted Creeper", 1, 2, Rarity.COMMON, HeroClass.ANY, 2);
		setRace(Race.BEAST);
	}

	@Override
	public Minion summon() {
		Minion hauntedCreeper = createMinion();
		Spell deathrattle = new SummonSpell(new SpectralSpider(), new SpectralSpider());
		deathrattle.setTarget(EntityReference.NONE);
		hauntedCreeper.addDeathrattle(deathrattle);
		return hauntedCreeper;
	}
	
	private class SpectralSpider extends MinionCard {

		public SpectralSpider() {
			super("Spectral Spider", 1, 1, Rarity.COMMON, HeroClass.ANY, 1);
			setCollectible(false);
		}

		@Override
		public Minion summon() {
			return createMinion();
		}
		
	}

}

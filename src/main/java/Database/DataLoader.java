package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {
	public static List<Pokemon> loadPokemons(Connection conn) throws SQLException {
		List<Pokemon> pokemons = new ArrayList<>();
		String query = """
				SELECT p.id, p.nome, p.vida, tp.tipo1
				FROM pokemon p
				JOIN tipo_pokemon tp ON p.id = tp.idPokemon;
				""";

		try (PreparedStatement pstmt = conn.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				int vida = rs.getInt("vida");
				int tipo1 = rs.getInt("tipo1");

				Pokemon pokemon = new Pokemon(id, nome, vida, tipo1);
				pokemons.add(pokemon);
			}
		}
		return pokemons;
	}

	public static List<Ataque> loadAtaques(Connection conn) throws SQLException {
		List<Ataque> ataques = new ArrayList<>();
		String query = "SELECT id, nome, dano, effect, tipo FROM ataque;";

		try (PreparedStatement pstmt = conn.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				int dano = rs.getInt("dano");
				String effect = rs.getString("effect");
				int tipo = rs.getInt("tipo");

				Ataque ataque = new Ataque(id, nome, dano, effect, tipo);
				ataques.add(ataque);
			}
		}
		return ataques;
	}

	public static List<Tipo> loadTipos(Connection conn) throws SQLException {
		List<Tipo> tipos = new ArrayList<>();

		String query = "SELECT id, tipo FROM tipos;";
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

			while (rs.next()) {
				int id = rs.getInt("id");
				String tipo = rs.getString("tipo");

				Tipo t = new Tipo(id, tipo);
				tipos.add(t);
			}
		}
		return tipos;
	}
}

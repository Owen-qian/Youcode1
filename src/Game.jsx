import React, { useState, useEffect } from 'react';
import { Player, Monster } from './Person'; // 请替换成正确的文件路径

const Game = () => {
  const [player, setPlayer] = useState(new Player(100, 20, 10, 1.5, 'Player'));
  const [monsters, setMonsters] = useState([
    new Monster(80, 15, 5, 1.2, 'Homework'),
    new Monster(100, 20, 8, 1.3, 'The final exam'),
    new Monster(120, 25, 10, 1.4, 'The life')
  ]);
  const [currentMonsterIndex, setCurrentMonsterIndex] = useState(0);
  const [gameOver, setGameOver] = useState(false);
  const [playerTurn, setPlayerTurn] = useState(true);

  const handlePlayerAction = (action) => {
    if (!playerTurn) return; // Player can only act when it's their turn
    const currentMonster = monsters[currentMonsterIndex];
    switch (action) {
      case 'attack':
        const attackMessage = player.useAttack(currentMonster);
        setPlayer(new Player(player.HP, player.damage, player.defence, player.multiplier, player.name)); // Update player instance
        setMonsters([...monsters]);
        break;
      // Handle other actions...
    }
    setPlayerTurn(false); // End player's turn
  };

  useEffect(() => {
    const currentMonster = monsters[currentMonsterIndex];
    if (currentMonster.check()) {
      if (currentMonsterIndex + 1 < monsters.length) {
        setCurrentMonsterIndex(currentMonsterIndex + 1);
        setPlayer(new Player(100, 20, 10, 1.5, 'Player')); // Reset player's HP
      } else {
        setGameOver(true);
      }
    } else {
      setTimeout(() => {
        const monsterActionMessage = currentMonster.randomAction(player);
        setPlayer(new Player(player.HP, player.damage, player.defence, player.multiplier, player.name)); // Update player instance
        setMonsters([...monsters]);
        setPlayerTurn(true); // Start player's turn
      }, 1000);
    }
  }, [player, monsters, currentMonsterIndex]);

  return (
    <div>
      <div>Player HP: {player.HP}</div>
      <div>Monster HP: {monsters[currentMonsterIndex].HP}</div>
      {gameOver ? (
        <div>Game over! {player.check() ? 'You were defeated.' : 'You won!'}</div>
      ) : (
        <div>
          {playerTurn && (
            <>
              <button onClick={() => handlePlayerAction('attack')}>Attack</button>
              {/* Add buttons for other actions */}
            </>
          )}
        </div>
      )}
    </div>
  );
};

export default Game;

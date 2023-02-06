import { BattleService } from './../../services/battle.service';
import { Component, OnInit } from '@angular/core';
import { Battle } from 'src/app/models/battle';

@Component({
  selector: 'app-battle',
  templateUrl: './battle.component.html',
  styleUrls: ['./battle.component.css'],
})
export class BattleComponent implements OnInit{

  title = "ngBattle"
  selected : null | Battle = null;

  battle : Battle[] = [];
  newBattle: Battle | null = new Battle();
  editBattle: Battle | null = null;
  battles: Battle[] = [];

  constructor(private battleService:BattleService) {}

  ngOnInit() {
    this.reload();
  }
  setEditBattle(){
      this.editBattle = Object.assign({}, this.selected);
    }
    updateBattle(battle: Battle) {
          this.battleService.update(battle).subscribe  (  {
         next: (updateBattle) =>{
        this.editBattle = null;
        this.reload();
          },
         error: (error) => {
          console.error("BattleListComponent.updateBattle: error can not update ");
          console.error(error)
             }
      });
    }
        addBattle(battle: Battle): void{
          this.battleService.create(battle).subscribe();
          this.newBattle = new Battle();
          this.reload();
        }
        displayTable(): void{
          this.selected = null;
        }

        displayBattle(battle: Battle){
          this.selected = battle;
        }

        getNumberOfBattles(){
  return this.battles.length;
}

reload() {
  this.battleService.index().subscribe({
    next: (battleList) => {
      this.battles = battleList;
    },
    error: (err) => {
      console.error('Error loading battle list: ');
      console.error(err);
    },
  });
}

                            deleteBattle(id : number){
                              this.battleService.destroy(id).subscribe({
                                next: (data) => {
this.reload();
                                },
                                error: (err) => {
                                  console.error("BattleListCompenent.deleteBattle(): Error deleting battle")
                                  console.error(err);
                                }
                              });
                            }
                          }






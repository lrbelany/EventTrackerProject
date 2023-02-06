export class Battle {

id: number;
kills: number;
win: boolean;
mvpsss: boolean;
mvpss: boolean;
mvps: boolean;
points: number;
firePower: number;
captures: number;
battle: any;


constructor(
id: number = 0,
kills: number = 0,
win: boolean = false,
mvpsss: boolean = false,
mvpss: boolean = false,
mvps: boolean = false,
points: number = 0,
firePower: number = 0,
captures: number = 0
){
this.id =id;
this.kills = kills;
this.win = win;
this.mvpsss = mvpsss;
this.mvpss = mvpss;
this.mvps = mvps;
this.points =points;
this.firePower = firePower;
this.captures = captures;
}

}

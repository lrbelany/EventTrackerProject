import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/internal/operators/catchError';
import { environment } from 'src/environments/environment.development';
import { Battle } from 'src/app/models/battle';



@Injectable({
  providedIn: 'root'
})
export class BattleService {
  static index: any;


  battles: Battle[] = [
    new Battle(1, 7, true, false, false, false, 20600, 421962, 1),
    new Battle(1, 10, true, true, true, false, 18300, 300345, 0)
      ];

url = environment.baseUrl + 'api/battles';

  constructor(
private http: HttpClient

  ) { }

  index(): Observable<Battle[]> {
    return this.http.get<Battle[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error(
            'BattleService.index(): error retrieving battle: ' + err

          )
        )
      })
    )
  }


create(battle: Battle): Observable<Battle> {

  return this.http.post<Battle>(this.url, battle).pipe(
    catchError((err: any) => {
      console.log(err);
      return throwError(
        () =>
        new Error(
          "BattleService.create(): no battle created : " + err)
          )
        })
        )
}
update(battle: Battle):Observable<Battle> {
  return this.http.put<Battle>(`${this.url}/${battle.id}`, battle).pipe(
      catchError((err: any) => {
          console.log(err);
          return throwError(
        () =>
        new Error(
          "BattleService.update(): error updating battle: " + err
      )
          );
        })
  );
      }




destroy(id: number):Observable<void>  {

  return this.http.delete<void>(`${this.url}/${id}`).pipe(
    catchError((err: any) => {
      console.log(err);
      return throwError(
        () =>
        new Error(
          "BattleService.delete(): error deleting this battle: " + err
      )
      );
    })
  )}

  }


  //TODO: show create update destroy

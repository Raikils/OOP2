export class Room {

  public ID: number;
  public place: number;
  public clas: number;
  public booked: boolean;
  public price: number;

  constructor(ID: number, place: number, clas: number, booked: boolean, price: number) {
    this.ID = ID;
    this.place = place;
    this.clas = clas;
    this.booked = booked;
    this.price = price;
  }
}

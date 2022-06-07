export class Request {

  public ID: number;
  public place: number;
  public clas: number;
  public approved: boolean;
  public price: number;
  public IDROOM: number;

  constructor(ID: number, place: number, clas: number, approved: boolean, price: number, IDROOM: number) {
    this.ID = ID;
    this.place = place;
    this.clas = clas;
    this.approved = approved;
    this.price = price;
    this.IDROOM = IDROOM;
  }
}

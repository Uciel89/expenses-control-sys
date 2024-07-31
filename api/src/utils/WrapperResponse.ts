export class WrapperResponse<T> {
    constructor(
      public ok: boolean,
      public message: string,
      public body: T,
      public timestamp: Date = new Date()
    ) {}
  }
  
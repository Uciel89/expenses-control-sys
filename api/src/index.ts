import express, { Express, Request, Response } from "express";
import dotenv from "dotenv";
import logger from "./utils/logger";

dotenv.config();

const app: Express = express();
const port = process.env.PORT || 3000;

app.get("/", (req: Request, res: Response) => {
  res.send("Express + TypeScript Server");
});

// Middleware para registrar solicitudes HTTP en diferentes archivos según la ruta
/* app.use((req, res, next) => {
  const logFileName = `logs/${req.method}_${req.originalUrl.replace(/\//g, '_')}.log`;
  
  // Crear un nuevo transport para cada ruta
  logger.add(new winston.transports.File({ filename: logFileName }));

  // Registrar la solicitud
  logger.info(`${req.method} ${req.originalUrl}`);

  // Eliminar el transport después de registrar la solicitud para evitar acumulación de transportes
  logger.clear();

  next();
}); */

app.listen(port, () => {
  logger.info('Server running');
});
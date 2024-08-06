import express, { Express, Request, Response } from "express";
import cors from "cors";
import { router } from "../src/infraestructura/rutas/cuenta.rutas"
import logger from "./utils/logger";
import { PORT } from "./config/configFile";



const app: Express = express();
app.use(cors({
  origin: '*'
}));

app.use(express.json());
app.use('/api/v1', router);

app.listen(PORT, () => {
  logger.info(`Server running on port ${PORT}`);
});
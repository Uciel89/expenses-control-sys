import "dotenv/config";
import express, { Express, Request, Response } from "express";
import cors from "cors";
import { router } from "./routes/index";
import logger from "./utils/logger";
import { doesNotThrow } from "assert";
import { PORT } from "./config/configFile";



const app: Express = express();
app.use(cors({
  origin: '*'
}));

app.use(express.json());
app.use('/api/vi',router);

app.listen(PORT, () => {
  logger.info(`Server running on port ${PORT}`);
});
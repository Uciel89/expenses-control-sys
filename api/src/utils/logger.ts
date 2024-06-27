import winston, { format, transport } from "winston";
import DailyRotateFile from "winston-daily-rotate-file";

// Configuración de Winston para registro de solicitudes HTTP
const logger = winston.createLogger({
    format: format.combine(
        //format.simple()
        winston.format.timestamp(),
        winston.format.printf(({ timestamp, level, message }) => {
            return `[${timestamp}] ${level.toUpperCase()}: ${message}`;
        })
    ),
    transports: [
        new winston.transports.Console({
            level: 'debug',
        }),
        // Rotación de logs con fecha
        new DailyRotateFile({
            filename: './logs/application-%DATE%.log',
            datePattern: 'YYYY-MM-DD_HH-mm-ss',
            zippedArchive: true,
            maxSize: '20m',
            maxFiles: '7d',
          }),
    ]
});

export default logger;
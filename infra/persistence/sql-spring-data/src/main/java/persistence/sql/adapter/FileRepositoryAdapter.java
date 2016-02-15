package persistence.sql.adapter;

import domain.filemanager.api.entity.Permission;
import org.springframework.stereotype.Service;
import persistence.sql.mapper.FileMapper;
import persistence.sql.entity.File;
import persistence.sql.factory.FileFactory;
import persistence.sql.repository.FileRepository;

import javax.inject.Inject;
import java.util.Map;

@Service
public class FileRepositoryAdapter implements domain.filemanager.spi.FileRepository {

    @Inject private FileRepository fileRepository;
    @Inject private FileFactory fileFactory;
    @Inject private FileMapper fileMapper;

    @Override
    public domain.filemanager.api.entity.File findFileById(String fileId) {
        File file = fileRepository.findOne(Long.valueOf(fileId));
        return fileMapper.fileToDomainFile(file);
    }

    @Override
    public domain.filemanager.api.entity.File addFile(String fileName, byte[] data, String ownerId) {
        File fileToSave = fileFactory.createFile(fileName, data, ownerId);
        File fileSaved = fileRepository.save(fileToSave);
        return fileMapper.fileToDomainFile(fileSaved);
    }

    @Override
    public void shareFile(String fileId, Map<String, Permission> usersIdToShareWithPermission) {
    }

    @Override
    public void deleteFile(String fileId) {
        fileRepository.delete(Long.valueOf(fileId));
    }
}

package io.github.eggy03.cimari.rest.service.processor;

import io.github.eggy03.cimari.rest.entity.processor.Win32CacheMemory;
import io.github.eggy03.cimari.rest.mapping.processor.Win32CacheMemoryMapper;
import io.github.eggy03.cimari.rest.service.CommonServiceInterface;
import io.github.eggy03.cimari.rest.shell.query.Cimv2;
import io.github.eggy03.cimari.rest.terminal.TerminalResult;
import io.github.eggy03.cimari.rest.terminal.TerminalService;
import io.quarkus.cache.CacheResult;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class Win32CacheMemoryService implements CommonServiceInterface<Win32CacheMemory> {

    private final @NonNull TerminalService terminalService;
    private final @NonNull Win32CacheMemoryMapper mapper;

    @Override
    @CacheResult(cacheName = "Win32CacheMemory")
    public List<Win32CacheMemory> get(long timeout) {
        final TerminalResult terminalResult = terminalService.executeQuery(Cimv2.WIN32_CACHE_MEMORY, timeout);
        return mapper.mapToList(terminalResult.result(), Win32CacheMemory.class);
    }
}
